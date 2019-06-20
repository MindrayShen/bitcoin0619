package com.bitcoin.bitcoin.service.impl;

import com.bitcoin.bitcoin.dao.BlockMapper;
import com.bitcoin.bitcoin.dto.BlockListDto;
import com.bitcoin.bitcoin.po.Block;
import com.bitcoin.bitcoin.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

    @Override
    public List<BlockListDto> getRecentBlocks() {

        List<Block> blockListDtos = blockMapper.selectRecentBlock();
        ArrayList<BlockListDto> list = new ArrayList<>();
        for (Block block:blockListDtos) {
            BlockListDto blockListDto = new BlockListDto();
            blockListDto.setBlockhash(block.getBlockhash());
            blockListDto.setTransactions(block.getTransactions());
            blockListDto.setSize(block.getSize());
            blockListDto.setMiner(block.getMiner());
            blockListDto.setHeight(block.getHeight());
            long nowtime = new Date().getTime();
            long blocktime = block.getTime().getTime();
            long l = nowtime - blocktime;
            int a = (int) (l/1000/60);
            blockListDto.setTime((long) a);
            list.add(blockListDto);
        }

        return list;
    }
}
