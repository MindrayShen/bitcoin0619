package com.bitcoin.bitcoin.service;

import com.bitcoin.bitcoin.dto.BlockListDto;
import com.bitcoin.bitcoin.po.Block;

import java.util.List;

public interface BlockService {

    List<BlockListDto> getRecentBlocks();

    List<BlockListDto> getRecentBlockList(Long time);

    Block getheight(Integer height);
}
