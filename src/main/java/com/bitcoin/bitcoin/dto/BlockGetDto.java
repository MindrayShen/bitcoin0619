package com.bitcoin.bitcoin.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockGetDto {

    private String blockhash;

    private Integer height;

    private Long time;

    private Short transactions;

    private String miner;

    private Float size;

    private Float outputtotal;

    private String merkleroot;

    private Float estimated;

    private Float fees;

    private Double difficulty;

    private Float weight;

    private Float bits;

    private String version;

    private Integer nonce;

    private String nextBlock;

    private String prevBlock;

    private Float blockreward;

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

    public Float getOutputtotal() {
        return outputtotal;
    }

    public void setOutputtotal(Float outputtotal) {
        this.outputtotal = outputtotal;
    }

    public String getMerkleroot() {
        return merkleroot;
    }

    public void setMerkleroot(String merkleroot) {
        this.merkleroot = merkleroot;
    }

    public Float getEstimated() {
        return estimated;
    }

    public void setEstimated(Float estimated) {
        this.estimated = estimated;
    }

    public Float getFees() {
        return fees;
    }

    public void setFees(Float fees) {
        this.fees = fees;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getBits() {
        return bits;
    }

    public void setBits(Float bits) {
        this.bits = bits;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getNonce() {
        return nonce;
    }

    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    public String getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(String nextBlock) {
        this.nextBlock = nextBlock;
    }

    public String getPrevBlock() {
        return prevBlock;
    }

    public void setPrevBlock(String prevBlock) {
        this.prevBlock = prevBlock;
    }

    public Float getBlockreward() {
        return blockreward;
    }

    public void setBlockreward(Float blockreward) {
        this.blockreward = blockreward;
    }
}
