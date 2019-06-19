package com.bitcoin.bitcoin.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpcApi {

    JSONObject getBlockchainInfo() throws Throwable;

    JSONObject getBlockByHash(String blockhash) throws Throwable;

    JSONObject getTransactionById(String txhash) throws Throwable;

    JSONObject getMemPool() throws Throwable;

    String getHashByHeight(Integer height) throws Throwable;

    JSONObject getBlockHeaders(String blockhash) throws Throwable;

}
