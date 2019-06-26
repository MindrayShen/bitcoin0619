package com.bitcoin.bitcoin.dao;

import com.bitcoin.bitcoin.dto.TransactionAndDetailList;
import com.bitcoin.bitcoin.po.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    List<Transaction> selectRecentTransaction();

    List<TransactionAndDetailList> selectbetween(@Param("start") String start, @Param("end") String end);
}