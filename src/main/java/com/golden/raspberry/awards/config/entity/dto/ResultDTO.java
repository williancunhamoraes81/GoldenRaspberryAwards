package com.golden.raspberry.awards.config.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {

    private List<ResultTypeDTO> min;
    private List<ResultTypeDTO> max;

}
