package com.bitcoin.bitcoin.dao;

import com.bitcoin.bitcoin.dto.BlockListDto;
import com.bitcoin.bitcoin.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    //SELECT *
    List<Block> selectRecentBlock();

    //SELECT between
    List<BlockListDto> selectbetween(@Param("start") String start,@Param("end") String end);

    Block selectheight(Integer height);
}