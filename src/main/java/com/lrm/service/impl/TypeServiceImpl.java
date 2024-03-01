package com.lrm.service.impl;

import com.lrm.NotFoundException;
import com.lrm.dao.TypeRepository;
import com.lrm.dto.TypeListDTO;
import com.lrm.mapper.ObjectMapper;
import com.lrm.po.Type;
import com.lrm.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    /*    Spring支持的request参数如下：

        page，第几页，从0开始，默认为第0页
        size，每一页的大小，默认为20
        sort，排序相关的信息，例如sort=firstname&sort=lastname,desc表示在按firstname正序排列基础上按lastname倒序排列*/
    @Override
    public List<TypeListDTO> listTypeTop(Integer size) {
        Pageable pageable = PageRequest.of(0, size, Sort.unsorted()); // 不指定排序
        List<Type> types = typeRepository.findTypesWithMostBlogs(pageable);

        // 转换每个 Type 实体为 TypeListDTO
        return types.stream()
                .map(ObjectMapper::toTypeListDTO)
                .collect(Collectors.toList());
    }


    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }



    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }



}
