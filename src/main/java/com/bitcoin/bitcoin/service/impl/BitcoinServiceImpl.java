package com.bitcoin.bitcoin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bitcoin.bitcoin.api.BitcoinRestApi;
import com.bitcoin.bitcoin.dao.BlockMapper;
import com.bitcoin.bitcoin.po.Block;
import com.bitcoin.bitcoin.service.BitcoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BitcoinServiceImpl implements BitcoinService {

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BlockMapper blockMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Async
    public void synBlock(String blockhash) {
        logger.info("begin tp sync block from {}",blockhash);
        while (blockhash!=null && !blockhash.isEmpty()) {
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
            blockMapper.insert(block);
            blockhash = block.getNextBlock();
        }
        logger.info("end sync block");
    }

}
