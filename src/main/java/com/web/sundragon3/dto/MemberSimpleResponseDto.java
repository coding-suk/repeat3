package com.web.sundragon3.dto;

import lombok.Getter;

@Getter
public class MemberSimpleResponseDto {

    private final String name;

    public MemberSimpleResponseDto(String name) {
        this.name = name;
    }

}
