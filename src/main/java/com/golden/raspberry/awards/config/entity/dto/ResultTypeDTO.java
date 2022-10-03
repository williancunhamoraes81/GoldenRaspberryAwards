package com.golden.raspberry.awards.config.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultTypeDTO {

    private String producer;
    private Integer interval;
    private String previousWin;
    private String followingWin;

}
