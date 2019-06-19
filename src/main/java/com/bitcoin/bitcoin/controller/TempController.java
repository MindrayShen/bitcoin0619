package com.bitcoin.bitcoin.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bitcoin.bitcoin.api.BitcoinJsonRpcApi;
import com.bitcoin.bitcoin.api.BitcoinRestApi;
import com.bitcoin.bitcoin.dto.BlockListDto;
import com.bitcoin.bitcoin.service.BlockService;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/temp")
public class TempController {

    /**
     *
     */
    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;

    @Autowired
    private BlockService blockService;

    @GetMapping("/test")
    public String test() {

//        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
//        JSONObject blockNoTxDetail = bitcoinRestApi.getBlockNoTxDetail("000000000000033ba3b0104d1c4f662f789caa7634670c49677aaa91f9ecb9a3");
        List<JSONObject> blockHeaders = bitcoinRestApi.getBlockHeaders(5, "000000000000033ba3b0104d1c4f662f789caa7634670c49677aaa91f9ecb9a3");
//        JSONObject txByHashJson = bitcoinRestApi.getTxByHashJson("48890e18fa956ed43d43c22297d159359bb446a3a45d63e668607f89a0dbbb99");
//        JSONObject hashByHeight = bitcoinRestApi.getHashByHeight(1543827);
//        JSONObject memPool = bitcoinRestApi.getMemPool();
//        JSONObject memPoolContents = bitcoinRestApi.getMemPoolContents();
        JSONObject utxo = bitcoinRestApi.getUTXO("537969f30ac81f0a0774c2835f290ede087c950083e1a93b481fc54e2c52eddb", 1);
        JSONObject utxoMempool = bitcoinRestApi.getUTXOMempool("537969f30ac81f0a0774c2835f290ede087c950083e1a93b481fc54e2c52eddb", 1);
        return blockHeaders.toString();

    }



    @GetMapping("/test1")
    public String test1() throws Throwable {

//        HashMap<String,String> headers = new HashMap<>();
//        String admin = "root:root";
//        String s = Base64.getEncoder().encodeToString(admin.getBytes());
//        String format = String.format("Basic "+s);
//        headers.put("Authorization",format);
//
//
//        JsonRpcHttpClient client = new JsonRpcHttpClient(
//                new URL("http://localhost:18332/"),headers);
//
//        JSONObject user = client.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);

        JSONObject blockchainInfo = bitcoinJsonRpcApi.getBlockchainInfo();
        JSONObject blockByHash = bitcoinJsonRpcApi.getBlockByHash("00000000000002e3e9b76bcba2d6b22ce91d219a7b8b612a57b8f4a1c2a04965");
        JSONObject transactionById = bitcoinJsonRpcApi.getTransactionById("6f59562349e354c649b65fa33fafb6589812cf9766e41cd1d079b9f702e00b9c");
        JSONObject memPool = bitcoinJsonRpcApi.getMemPool();
        String hashByHeight = bitcoinJsonRpcApi.getHashByHeight(1543827);
        JSONObject blockHeaders = bitcoinJsonRpcApi.getBlockHeaders("000000000000033ba3b0104d1c4f662f789caa7634670c49677aaa91f9ecb9a3");
        return null;
    }

    @GetMapping("/test2")
    public List<BlockListDto> test2(){
        List<BlockListDto> recentBlocks = blockService.getRecentBlocks();
        return recentBlocks;
    }
}

