package com.bitcoin.bitcoin.po;

import java.util.Date;

public class Block {
    private String blockhash;

    private Integer height;

    private Date time;

    private Short transactions;

    private String miner;

    private Float size;

    private Float outputtotal;

    private String merkleroot;

    private Float estimated;

    private Float fees;

    private Double difficulty;

    private Float weight;

    private String bits;

    private String version;

    private Integer nonce;

    private String nextBlock;

    private String prevBlock;

    private Float blockreward;

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash == null ? null : blockhash.trim();
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
        this.miner = miner == null ? null : miner.trim();
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
        this.merkleroot = merkleroot == null ? null : merkleroot.trim();
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

    public String getBits() {
        return bits;
    }

    public void setBits(String bits) {
        this.bits = bits == null ? null : bits.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
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
        this.nextBlock = nextBlock == null ? null : nextBlock.trim();
    }

    public String getPrevBlock() {
        return prevBlock;
    }

    public void setPrevBlock(String prevBlock) {
        this.prevBlock = prevBlock == null ? null : prevBlock.trim();
    }

    public Float getBlockreward() {
        return blockreward;
    }

    public void setBlockreward(Float blockreward) {
        this.blockreward = blockreward;
    }
}