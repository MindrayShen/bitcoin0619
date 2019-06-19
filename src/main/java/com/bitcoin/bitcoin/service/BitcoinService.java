package com.bitcoin.bitcoin.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BitcoinService {

        void synBlock(String blockhash);

        void syncTx(JSONObject txjson, String blockhash, Date time, Short confirmations);

        void syncTxDetail(JSONObject txjson);

}
