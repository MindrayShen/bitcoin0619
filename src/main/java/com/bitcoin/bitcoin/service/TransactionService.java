package com.bitcoin.bitcoin.service;

import com.bitcoin.bitcoin.dto.SreachGetDto;
import com.bitcoin.bitcoin.dto.TransactionAndDetailList;
import com.bitcoin.bitcoin.dto.TransactionListDto;
import com.bitcoin.bitcoin.po.Transaction;

import java.util.List;

public interface TransactionService {

    List<TransactionListDto> getRecentTransactions();

    List<TransactionAndDetailList> getRecentTransactionList(long newtime);

    SreachGetDto selectSreach(String sreach);
}
