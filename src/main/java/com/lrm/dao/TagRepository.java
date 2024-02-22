package com.lrm.dao;

import com.lrm.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);

    @Query("SELECT t FROM Tag t LEFT JOIN t.blogs b GROUP BY t ORDER BY COUNT(b) DESC")
    List<Tag> findTagsWithMostBlogs(Pageable pageable);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);

}
