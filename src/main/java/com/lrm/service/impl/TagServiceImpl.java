package com.lrm.service.impl;

import com.lrm.NotFoundException;
import com.lrm.dao.TagRepository;
import com.lrm.dto.TagListDTO;
import com.lrm.mapper.ObjectMapper;
import com.lrm.po.Tag;
import com.lrm.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;


@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.findById(id).get();
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }


/*    Spring支持的request参数如下：

    page，第几页，从0开始，默认为第0页
    size，每一页的大小，默认为20
    sort，排序相关的信息，例如sort=firstname&sort=lastname,desc表示在按firstname正序排列基础上按lastname倒序排列*/
    @Override
    public List<TagListDTO> listTagTop(Integer size) {
        Pageable pageable = PageRequest.of(0, size);
        List<Tag> tags = tagRepository.findTagsWithMostBlogs(pageable);
        return tags.stream()
                .map(ObjectMapper::toTagListDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Tag> listTag(String ids) { //1,2,3
        return tagRepository.findAllById(convertToList(ids));
    }

    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (String s : idarray) {
                list.add(parseLong(s));
            }
        }
        return list;
    }


    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(tag,t);
        return tagRepository.save(t);
    }



    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
