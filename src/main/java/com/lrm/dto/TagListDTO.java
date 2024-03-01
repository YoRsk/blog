package com.lrm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TagListDTO {
    private Long id;
    private String name;
    private int blogCount;

    //Other DTO
    private List<BlogDTO> blogs;
}
