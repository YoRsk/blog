package com.lrm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BlogListDTO {
    private Long id;
    private String title;
    private String description;
    private Date updateTime;
    private Integer views;
    private String firstPicture;

    //Other DTOs
    private UserDTO user;
    private TypeDTO type;
}
