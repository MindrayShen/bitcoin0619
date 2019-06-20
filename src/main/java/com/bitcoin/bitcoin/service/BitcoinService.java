package com.bitcoin.bitcoin.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BitcoinService {

        void syncBlockchainFromHash(String blockhash) throws Throwable;

        String synBlock(String blockhash) throws Throwable;

        void syncTx(JSONObject txjson, String blockhash, Date time, Short confirmations) throws Throwable;

        void syncTxDetail(JSONObject txjson,String txid) throws Throwable;

}
