package com.bondarenko.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DataDto {
    private int id;
    private String data;
    private LocalDateTime updatedTime;
}
