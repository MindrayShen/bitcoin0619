package com.bitcoin.bitcoin.dto;

import java.util.List;

public class BlockTimeGetDto {

    private List<BlockListDto> blockListDtoList;

    private Long time;

    public List<BlockListDto> getBlockListDtoList() {
        return blockListDtoList;
    }

    public void setBlockListDtoList(List<BlockListDto> blockListDtoList) {
        this.blockListDtoList = blockListDtoList;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
