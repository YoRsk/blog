package com.lrm.dao;

import com.lrm.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
    @Query("SELECT t FROM Type t LEFT JOIN t.blogs b GROUP BY t.id ORDER BY COUNT(b) DESC")
    List<Type> findTypesWithMostBlogs(Pageable pageable);
}
