package com.bitcoin.bitcoin.service;

import com.bitcoin.bitcoin.dto.TransactionListDto;

import java.util.List;

public interface TransactionService {

    List<TransactionListDto> getRecentTransactions();

}
