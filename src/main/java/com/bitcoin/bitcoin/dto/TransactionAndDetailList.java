package com.bitcoin.bitcoin.dto;

import com.bitcoin.bitcoin.po.Transaction;
import com.bitcoin.bitcoin.po.Transaction_detail;

import java.util.Date;
import java.util.List;

public class TransactionAndDetailList {

    private String txhash;

    private Date time;

    private Float amount;

    private Float feeperbyte;

    private Float feeperweight;

    private Float fees;

    private Short weight;

    private Float totaloutput;

    private Float totalinput;

    private Short size;

    private Short confirmations;

    private String visualize;

    private String estimated;

    private String blockhash;

    private String scripts;

    private List<Transaction_detail> transaction_details;

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getFeeperbyte() {
        return feeperbyte;
    }

    public void setFeeperbyte(Float feeperbyte) {
        this.feeperbyte = feeperbyte;
    }

    public Float getFeeperweight() {
        return feeperweight;
    }

    public void setFeeperweight(Float feeperweight) {
        this.feeperweight = feeperweight;
    }

    public Float getFees() {
        return fees;
    }

    public void setFees(Float fees) {
        this.fees = fees;
    }

    public Short getWeight() {
        return weight;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    public Float getTotaloutput() {
        return totaloutput;
    }

    public void setTotaloutput(Float totaloutput) {
        this.totaloutput = totaloutput;
    }

    public Float getTotalinput() {
        return totalinput;
    }

    public void setTotalinput(Float totalinput) {
        this.totalinput = totalinput;
    }

    public Short getSize() {
        return size;
    }

    public void setSize(Short size) {
        this.size = size;
    }

    public Short getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Short confirmations) {
        this.confirmations = confirmations;
    }

    public String getVisualize() {
        return visualize;
    }

    public void setVisualize(String visualize) {
        this.visualize = visualize;
    }

    public String getEstimated() {
        return estimated;
    }

    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public String getScripts() {
        return scripts;
    }

    public void setScripts(String scripts) {
        this.scripts = scripts;
    }

    public List<Transaction_detail> getTransaction_details() {
        return transaction_details;
    }

    public void setTransaction_details(List<Transaction_detail> transaction_details) {
        this.transaction_details = transaction_details;
    }
}
