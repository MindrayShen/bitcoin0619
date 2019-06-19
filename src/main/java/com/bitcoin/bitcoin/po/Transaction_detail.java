package com.bitcoin.bitcoin.po;

public class Transaction_detail {
    private Long txDetailId;

    private String address;

    private Float amount;

    private Byte type;

    private String txhash;

    private Integer notransactios;

    private Float totalreceived;

    private Float finalbalance;

    private String transactionaddress;

    public Long getTxDetailId() {
        return txDetailId;
    }

    public void setTxDetailId(Long txDetailId) {
        this.txDetailId = txDetailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash == null ? null : txhash.trim();
    }

    public Integer getNotransactios() {
        return notransactios;
    }

    public void setNotransactios(Integer notransactios) {
        this.notransactios = notransactios;
    }

    public Float getTotalreceived() {
        return totalreceived;
    }

    public void setTotalreceived(Float totalreceived) {
        this.totalreceived = totalreceived;
    }

    public Float getFinalbalance() {
        return finalbalance;
    }

    public void setFinalbalance(Float finalbalance) {
        this.finalbalance = finalbalance;
    }

    public String getTransactionaddress() {
        return transactionaddress;
    }

    public void setTransactionaddress(String transactionaddress) {
        this.transactionaddress = transactionaddress == null ? null : transactionaddress.trim();
    }
}