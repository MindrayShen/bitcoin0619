package com.bitcoin.bitcoin.dao;

import com.bitcoin.bitcoin.po.Transaction_detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Transaction_detailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(Transaction_detail record);

    int insertSelective(Transaction_detail record);

    Transaction_detail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(Transaction_detail record);

    int updateByPrimaryKey(Transaction_detail record);

    List<Transaction_detail> selectByTxHash(@Param("txhash") String txhash);

    Transaction_detail selectByAddress(@Param("sreach")String sreach);

    Float selectAmount(@Param("txhash") String txhash);
}