package com.bitcoin.bitcoin.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bitcoin.bitcoin.api.BitcoinJsonRpcApi;
import com.bitcoin.bitcoin.api.BitcoinRestApi;
import com.bitcoin.bitcoin.dao.BlockMapper;
import com.bitcoin.bitcoin.dao.TransactionMapper;
import com.bitcoin.bitcoin.dao.Transaction_detailMapper;
import com.bitcoin.bitcoin.enumeration.TxDetailType;
import com.bitcoin.bitcoin.po.Block;
import com.bitcoin.bitcoin.po.Transaction;
import com.bitcoin.bitcoin.po.Transaction_detail;
import com.bitcoin.bitcoin.service.BitcoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;

@Service
public class BitcoinServiceImpl implements BitcoinService {

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private Transaction_detailMapper transaction_detailMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void syncBlockchainFromHash(String blockhash) throws Throwable {

        logger.info("begin tp sync block from {}",blockhash);

        while (blockhash!=null && !blockhash.isEmpty()) {
            String s = synBlock(blockhash);
            blockhash=s;
        }

        logger.info("end sync block");

    }

    @Override
    @Async
    @Transactional
    public String synBlock(String blockhash) throws Throwable {

            JSONObject blockedil = bitcoinRestApi.getBlock(blockhash);
            Block block = new Block();
            block.setBlockhash(blockedil.getString("hash"));
            block.setBits(blockedil.getString("bits"));
            block.setBlockreward(null);
            block.setDifficulty(blockedil.getDouble("difficulty"));
            block.setEstimated(null);
            block.setFees(null);
            block.setHeight(blockedil.getInteger("height"));
            block.setMerkleroot(blockedil.getString("merkleroot"));
            block.setMiner(null);
            block.setNextBlock(blockedil.getString("nextblockhash"));
            block.setNonce(blockedil.getInteger("nonce"));
            block.setOutputtotal(null);
            block.setPrevBlock(blockedil.getString("previousblockhash"));
            block.setSize(blockedil.getFloat("size"));
            block.setTime(new Date(blockedil.getLong("time")*1000));
            block.setTransactions(blockedil.getShort("nTx"));
            block.setVersion(blockedil.getString("version"));
            block.setWeight(blockedil.getFloat("weight"));
            Short confirmations = blockedil.getShort("confirmations");
            blockMapper.insert(block);

            JSONArray tx = blockedil.getJSONArray("tx");

            //todo sync tx
            for (Object txobj:tx) {

                JSONObject jsonObject = new JSONObject((LinkedHashMap) txobj);

                syncTx(jsonObject,blockhash,new Date(blockedil.getLong("time")*1000),confirmations);

            }


            return block.getNextBlock();

    }


    @Override
    @Transactional
    public void syncTx(JSONObject txjson, String blockhash, Date time,Short confirmations) throws Throwable {
        Transaction transaction = new Transaction();
        transaction.setWeight(txjson.getShort("weight"));
        transaction.setVisualize(null);
        transaction.setTxhash(txjson.getString("txid"));
        transaction.setTotaloutput(null);
        transaction.setTotalinput(null);
        transaction.setTime(time);
        transaction.setSize(txjson.getShort("size"));
        transaction.setScripts(null);
        transaction.setFees(null);
        transaction.setFeeperweight(null);
        transaction.setFeeperbyte(null);
        transaction.setEstimated(null);
        transaction.setConfirmations(confirmations);
        transaction.setBlockhash(blockhash);
        transaction.setAmount(null);
        transactionMapper.insert(transaction);

        //todo set tx detail
        syncTxDetail(txjson,txjson.getString("txid"));
        //todo set tx amount
    }

    @Override
    @Transactional
    public void syncTxDetail(JSONObject txjson,String txid) throws Throwable {
        JSONArray vin = txjson.getJSONArray("vin");
        for (Object vinobj:vin) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vinobj);
            String vintxid = jsonObject.getString("txid");
            Integer n = jsonObject.getInteger("vout");

            if(vintxid!=null){
                JSONObject transactionById = bitcoinJsonRpcApi.getTransactionById(vintxid);
                JSONArray vout = transactionById.getJSONArray("vout");
                JSONObject utxoJSon = vout.getJSONObject(n);
                Transaction_detail transaction_detail = new Transaction_detail();

                transaction_detail.setType((byte) TxDetailType.Send.ordinal());
                transaction_detail.setTxhash(txid);
                transaction_detail.setTotalreceived(null);
                transaction_detail.setNotransactios(null);
                transaction_detail.setFinalbalance(null);
                transaction_detail.setAmount(-utxoJSon.getFloat("value"));
                transaction_detail.setAddress(null);
                JSONObject scriptPubKey = jsonObject.getJSONObject("scriptPubKey");
                JSONArray addresses = jsonObject.getJSONArray("addresses");
                if(addresses!=null) {
                    transaction_detail.setTransactionaddress(addresses.getString(0));
                }
                transaction_detailMapper.insert(transaction_detail);
            }
        }

        JSONArray vout = txjson.getJSONArray("vout");
        for (Object voutobj:vout) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) voutobj);
            Transaction_detail transaction_detail = new Transaction_detail();
            transaction_detail.setType((byte) TxDetailType.Receive.ordinal());
            transaction_detail.setTxhash(txid);
            transaction_detail.setTotalreceived(null);
            transaction_detail.setNotransactios(null);
            transaction_detail.setFinalbalance(null);
            transaction_detail.setAmount(jsonObject.getFloat("value"));
            transaction_detail.setAddress(null);
            JSONObject scriptPubKey = jsonObject.getJSONObject("scriptPubKey");
            JSONArray addresses = jsonObject.getJSONArray("addresses");
            if(addresses!=null) {
                transaction_detail.setTransactionaddress(addresses.getString(0));
            }
            transaction_detailMapper.insert(transaction_detail);
        }
    }

}
