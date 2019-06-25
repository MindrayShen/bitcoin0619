package com.bitcoin.bitcoin.service;

import com.bitcoin.bitcoin.dto.TransactionListDto;
import com.bitcoin.bitcoin.po.Transaction;

import java.util.List;

public interface TransactionService {

    List<TransactionListDto> getRecentTransactions();

    List<Transaction> getRecentTransactionList(long newtime);

    Object selectSreach(String sreach);
}
