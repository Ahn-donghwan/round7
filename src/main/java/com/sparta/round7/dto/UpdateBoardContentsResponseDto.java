package com.sparta.round7.dto;

import lombok.Getter;

@Getter
public class UpdateBoardContentsResponseDto {

    private final Long id;
    private final String title;
    private final String contents;

    public UpdateBoardContentsResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
