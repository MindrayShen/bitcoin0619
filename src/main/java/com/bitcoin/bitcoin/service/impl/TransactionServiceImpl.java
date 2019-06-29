package com.bitcoin.bitcoin.service.impl;

import com.bitcoin.bitcoin.dao.BlockMapper;
import com.bitcoin.bitcoin.dao.TransactionMapper;
import com.bitcoin.bitcoin.dao.Transaction_detailMapper;
import com.bitcoin.bitcoin.dto.SreachGetDto;
import com.bitcoin.bitcoin.dto.TransactionAndDetailList;
import com.bitcoin.bitcoin.dto.TransactionListDto;
import com.bitcoin.bitcoin.po.Block;
import com.bitcoin.bitcoin.po.Transaction;
import com.bitcoin.bitcoin.po.Transaction_detail;
import com.bitcoin.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService
{

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private Transaction_detailMapper transaction_detailMapper;

    @Autowired
    private BlockMapper blockMapper;

    @Override
    public List<TransactionListDto> getRecentTransactions() {
        List<Transaction> transactions = transactionMapper.selectRecentTransaction();
        List<TransactionListDto> list = new ArrayList<>();
        for (Transaction tx:transactions) {
            TransactionListDto transactionListDto = new TransactionListDto();
            transactionListDto.setAmount(tx.getAmount());
            transactionListDto.setTxhash(tx.getTxhash());
            long nowtime = new Date().getTime();
            long transactionListDtotime = tx.getTime().getTime();
            long l = nowtime - transactionListDtotime;
            int a = (int) (l/1000/60);
            transactionListDto.setTime((long) a);
            Float amount = transaction_detailMapper.selectAmount(tx.getTxhash());
            transactionListDto.setAmount(amount*-1);
            list.add(transactionListDto);
        }
        return list;
    }

    @Override
    public List<TransactionAndDetailList> getRecentTransactionList(long newtime) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(newtime);
        StringBuffer stringBuffer = new StringBuffer(format);
        StringBuffer stringBuffer1 = new StringBuffer(format);
        String start = String.valueOf(stringBuffer.append(" 00:00:00"));
        String end = String.valueOf(stringBuffer1.append(" 23:59:59"));
        List<TransactionAndDetailList> transactionAndDetailLists = transactionMapper.selectbetween(start,end);

        for (TransactionAndDetailList t:transactionAndDetailLists) {
            String txhash = t.getTxhash();
            List<Transaction_detail> transaction_details = transaction_detailMapper.selectByTxHash(txhash);
            t.setTransaction_details(transaction_details);

        }

        return transactionAndDetailLists;
    }

    //todo selectSreach
    @Override
    public SreachGetDto selectSreach(String sreach) {

        Block block = blockMapper.selectByPrimaryKey(sreach);
        if(block==null){
            Transaction transaction = transactionMapper.selectByPrimaryKey(sreach);
            if (transaction==null){
                return null;
            }else {
                SreachGetDto sreachGetDto = new SreachGetDto();
                sreachGetDto.setObject(transaction);
                sreachGetDto.setURL("transaction.html?object=");
                return sreachGetDto;
            }
        }
        SreachGetDto sreachGetDto = new SreachGetDto();
        sreachGetDto.setObject(block);
        sreachGetDto.setURL("block.html?object=");
        return sreachGetDto;
    }

}
