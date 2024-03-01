package com.lrm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TypeListDTO {
    private String name;
    private Long id;
    private int blogCount;

    //Other DTO
    List<BlogDTO> blogs;
}
