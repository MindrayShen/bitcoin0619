package com.bitcoin.bitcoin.controller;

import com.alibaba.fastjson.JSONObject;
import com.bitcoin.bitcoin.api.BitcoinJsonRpcApi;
import com.bitcoin.bitcoin.api.BitcoinRestApi;
import com.bitcoin.bitcoin.dao.TransactionMapper;
import com.bitcoin.bitcoin.dto.*;
import com.bitcoin.bitcoin.po.Block;
import com.bitcoin.bitcoin.po.Transaction;
import com.bitcoin.bitcoin.po.Transaction_detail;
import com.bitcoin.bitcoin.service.BlockService;
import com.bitcoin.bitcoin.service.TransactionService;
import com.bitcoin.bitcoin.service.Transaction_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
@CrossOrigin
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

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private Transaction_detailService transaction_detailService;


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

    @GetMapping("/block")
    public List<BlockListDto> block(){
        List<BlockListDto> recentBlocks = blockService.getRecentBlocks();
        return recentBlocks;
    }

    @GetMapping("/transaction")
    public List<TransactionListDto> transaction(){
        List<TransactionListDto> recentTransactions = transactionService.getRecentTransactions();
        return recentTransactions;
    }

    @GetMapping("/blocklist")
    public BlockTimeGetDto blocklist(){
        long newtime = new Date().getTime();
        List<BlockListDto> recentBlockLi3st = blockService.getRecentBlockList(newtime);
        BlockTimeGetDto blockTimeGetDto = new BlockTimeGetDto();
        blockTimeGetDto.setBlockListDtoList(recentBlockLi3st);
        blockTimeGetDto.setTime(newtime);
        return blockTimeGetDto;
    }

    //todo transaction
    @GetMapping("/transactionlist")
    public List<TransactionAndDetailList> transactionlist(){
        long newtime = new Date().getTime();
        List<TransactionAndDetailList> transactionAndDetailLists = transactionService.getRecentTransactionList(newtime);

        return transactionAndDetailLists;
    }

    @GetMapping("/sreach")
    public SreachGetDto sreach(@RequestParam String sreach ){

        if(sreach.length()<8){
            if(sreach.matches("^\\d+$")){
                //高度
                int height = Integer.parseInt(sreach);
                Block block = blockService.getheight(height);
                SreachGetDto sreachGetDto = new SreachGetDto();
                sreachGetDto.setObject(block);
                sreachGetDto.setURL("block.html?object=");
                return  sreachGetDto;
            }
            return null;
        }else if(sreach.length()==64){
            if(sreach.matches("^[0-9a-f]+$")){
                //Hash
                SreachGetDto sreachGetDto = transactionService.selectSreach(sreach);
                return sreachGetDto;
            }
            return null;
        }else if(sreach.length()>10&&sreach.length()<50){
            //地址
            Transaction_detail transaction_detail = transaction_detailService.selectaddress(sreach);
            SreachGetDto sreachGetDto = new SreachGetDto();
            sreachGetDto.setObject(transaction_detail);
            sreachGetDto.setURL("transaction_detail.html?object=");
            return sreachGetDto;
        }

        return null;
    }

    @GetMapping("/preblock")
    public BlockTimeGetDto preblock(@RequestParam Long time){

        long pretime = time-86400000;
        List<BlockListDto> blockListDtoList = blockService.getRecentBlockList(pretime);
        BlockTimeGetDto blockTimeGetDto = new BlockTimeGetDto();
        blockTimeGetDto.setBlockListDtoList(blockListDtoList);
        blockTimeGetDto.setTime(pretime);
        return blockTimeGetDto;

    }

    @GetMapping("/nextblock")
    public BlockTimeGetDto nextblock(@RequestParam Long time){

        long nexttime = time+86400000;
        List<BlockListDto> blockListDtoList = blockService.getRecentBlockList(nexttime);
        BlockTimeGetDto blockTimeGetDto = new BlockTimeGetDto();
        blockTimeGetDto.setBlockListDtoList(blockListDtoList);
        blockTimeGetDto.setTime(nexttime);

        return blockTimeGetDto;

    }
}