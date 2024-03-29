package com.lrm.service;

import com.lrm.dto.TypeDTO;
import com.lrm.dto.TypeListDTO;
import com.lrm.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<TypeListDTO> listTypeTop(Integer size);

    Type updateType(Long id,Type type);

    void deleteType(Long id);
}
