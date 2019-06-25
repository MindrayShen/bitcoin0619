package com.bitcoin.bitcoin.service.impl;

import com.bitcoin.bitcoin.dao.Transaction_detailMapper;
import com.bitcoin.bitcoin.po.Transaction_detail;
import com.bitcoin.bitcoin.service.TransactionService;
import com.bitcoin.bitcoin.service.Transaction_detailService;
import org.springframework.beans.factory.annotation.Autowired;

public class Transaction_detailServiceImpl implements Transaction_detailService {

    @Autowired
    private Transaction_detailMapper transaction_detailMapper;


    //todo selectaddress
    @Override
    public Transaction_detail selectaddress(String sreach) {



        return null;
    }
}
