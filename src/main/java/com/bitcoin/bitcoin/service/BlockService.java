package com.bitcoin.bitcoin.service;

import com.bitcoin.bitcoin.dto.BlockListDto;

import java.util.List;

public interface BlockService {

    List<BlockListDto> getRecentBlocks();

}
