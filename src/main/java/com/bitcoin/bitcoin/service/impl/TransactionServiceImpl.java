package com.bitcoin.bitcoin.service.impl;

import com.bitcoin.bitcoin.dao.TransactionMapper;
import com.bitcoin.bitcoin.dto.TransactionListDto;
import com.bitcoin.bitcoin.po.Transaction;
import com.bitcoin.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

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
            list.add(transactionListDto);
        }
        return list;
    }

}
