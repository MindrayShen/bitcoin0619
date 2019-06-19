package com.bitcoin.bitcoin.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockListDto {

    private String blockhash;

    private Integer height;

    private Long time;

    private Short transactions;

    private String miner;

    private Float size;

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Short getTransactions() {
        return transactions;
    }

    public void setTransactions(Short transactions) {
        this.transactions = transactions;
    }

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }
}
