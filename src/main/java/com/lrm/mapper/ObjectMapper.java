package com.lrm.mapper;

import com.lrm.dto.*;
import com.lrm.po.Blog;
import com.lrm.po.Tag;
import com.lrm.po.Type;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapper {
    public static BlogDTO toBlogDTO(Blog blog){
        BlogDTO dto = new BlogDTO();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setDescription(blog.getDescription());
        dto.setUpdateTime(blog.getUpdateTime());
        dto.setViews(blog.getViews());
        dto.setFirstPicture(blog.getFirstPicture());

        return dto;
    }
    public static BlogListDTO toBlogListDTO(Blog blog) {
        BlogListDTO dto = new BlogListDTO();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setDescription(blog.getDescription());
        dto.setUpdateTime(blog.getUpdateTime());
        dto.setViews(blog.getViews());
        dto.setFirstPicture(blog.getFirstPicture());

        UserDTO userDTO = new UserDTO();
        userDTO.setAvatar(blog.getUser().getAvatar());
        userDTO.setNickname(blog.getUser().getNickname());
        dto.setUser(userDTO);

        TypeDTO typeDTO = new TypeDTO();
        typeDTO.setName(blog.getType().getName());
        typeDTO.setId(blog.getType().getId());
        dto.setType(typeDTO);

        return dto;
    }
    public static TypeListDTO toTypeListDTO(Type type) {
        TypeListDTO typeListDTO = new TypeListDTO();
        typeListDTO.setId(type.getId());
        typeListDTO.setName(type.getName());

        // fill up the blog list
        List<BlogDTO> blogDTOs = type.getBlogs().stream()
                .map(ObjectMapper::toBlogDTO)
                .toList();

        typeListDTO.setBlogs(blogDTOs);
        typeListDTO.setBlogCount(type.getBlogs().size());

        return typeListDTO;
    }

    public static TagListDTO toTagListDTO(Tag tag) {
        TagListDTO tagListDTO = new TagListDTO();
        tagListDTO.setId(tag.getId());
        tagListDTO.setName(tag.getName());

        List<BlogDTO> blogDTOs = tag.getBlogs().stream()
                .map(ObjectMapper::toBlogDTO)
                .collect(Collectors.toList());

        tagListDTO.setBlogs(blogDTOs);
        tagListDTO.setBlogCount(tag.getBlogs().size());

        return tagListDTO;
    }

}
