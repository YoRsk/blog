package com.lrm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class BlogDTO {
    private Long id;
    private String title;
    private String description;
    private Date updateTime;
    private Integer views;
    private String firstPicture;
}
