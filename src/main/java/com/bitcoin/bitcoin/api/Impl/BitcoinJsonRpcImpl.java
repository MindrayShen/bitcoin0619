package com.bitcoin.bitcoin.api.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bitcoin.bitcoin.api.BitcoinJsonRpcApi;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.BitSet;
import java.util.HashMap;

@Component
public class BitcoinJsonRpcImpl implements BitcoinJsonRpcApi {

    private JsonRpcHttpClient jsonRpcHttpClient;

    public BitcoinJsonRpcImpl(@Value("${bitcoin.jsonrpc.username}") String username, @Value("${bitcoin.jsonrpc.password}") String password,
                              @Value("${bitcoin.jsonrpc.url}") String url) throws MalformedURLException {

        HashMap<String, String> headers = new HashMap<>();
        String admin = username + ":" + password;
        String s = Base64.getEncoder().encodeToString(admin.getBytes());
        String format = String.format("Basic " + s);
        headers.put("Authorization", format);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL(url), headers);

    }

    @Override
    public JSONObject getBlockchainInfo() throws Throwable {

        JSONObject getblockchaininfo = jsonRpcHttpClient.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);

        return getblockchaininfo;
    }

    @Override
    public JSONObject getBlockByHash(String blockhash) throws Throwable {

        JSONObject getblock = jsonRpcHttpClient.invoke("getblock", new Object[]{blockhash}, JSONObject.class);

        return getblock;
    }

    @Override
    public JSONObject getTransactionById(String txhash) throws Throwable {

        JSONObject getrawtransaction = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txhash, true}, JSONObject.class);

        return getrawtransaction;
    }

    @Override
    public JSONObject getMemPool() throws Throwable {

        JSONObject getmempoolinfo = jsonRpcHttpClient.invoke("getmempoolinfo", new Object[]{}, JSONObject.class);

        return getmempoolinfo;
    }

    //todo 1:02:22 因为它自动把数据封装啦起来 所以直接返回结果，不用转换json类型了
    @Override
    public String getHashByHeight(Integer height) throws Throwable {

        String getblockhash = jsonRpcHttpClient.invoke("getblockhash", new Object[]{height}, String.class);


        return getblockhash;
    }

    @Override
    public JSONObject getBlockHeaders(String blockhash) throws Throwable {

        JSONObject getblockheader = jsonRpcHttpClient.invoke("getblockheader", new Object[]{blockhash}, JSONObject.class);

        return getblockheader;
    }

}
