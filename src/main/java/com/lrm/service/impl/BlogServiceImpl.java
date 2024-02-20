package com.lrm.service.impl;

import com.lrm.NotFoundException;
import com.lrm.dao.BlogRepository;
import com.lrm.po.Blog;
import com.lrm.po.Type;
import com.lrm.service.BlogService;
import com.lrm.util.MarkdownUtils;
import com.lrm.util.MyBeanUtils;
import com.lrm.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.criteria.*;
import java.util.*;


@Service
public class BlogServiceImpl implements BlogService {


    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).get();
    }
//    @Transactional
//    @Override
//    public Blog getAndConvert(Long id) {
//        Blog blog = blogRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("该博客不存在"));
//        // 直接在查询到的实体上操作，避免创建新实例
//        // 注意：这会改变数据库对象的状态，但只要你不调用save方法，这些改变不会持久化到数据库
//        String content = blog.getContent();
//        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
//
//        // 由于这是一个事务性操作，这里调用updateViews不会立即执行SQL更新操作，
//        // 而是等到事务结束时。如果想要立即更新浏览量并反映到数据库中，
//        // 可以在updateViews方法内部执行flush操作。
//        blogRepository.updateViews(id);
//        return blog;
//    }
//    @Transactional
//    @Override
//    public Blog getAndConvert(Long id) {
//        Blog blog = blogRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("该博客不存在"));
//        Blog b = new Blog();
//        BeanUtils.copyProperties(blog, b);//有可能blog==null，需复制过来
//        String content = b.getContent();
//        b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
//        blogRepository.updateViews(id);
//        return b;
//    }
    @Transactional
    @Override
    public Blog getAndConvert(Long id) {
        Blog blog = blogRepository.findById(id).get();
        if (blog == null) {
            throw new NotFoundException("该博客不存在");
        }
        Blog b = new Blog();
        BeanUtils.copyProperties(blog, b);//有可能blog==null，需复制过来
        String content = b.getContent();
        b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        blogRepository.updateViews(id);
        return b;
    }
    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
                    predicates.add(cb.like(root.get("title"), "%" + blog.getTitle() + "%"));
                }
                if (blog.getTypeId() != null) {
                    predicates.add(cb.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
                }
                if (blog.isRecommend()) {
                    predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> listBlog(Long tagId, Pageable pageable) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Join<Object, Object> join = root.join("tags");//jpa中动态分类查询，通过tag的Id查询到页数来返回
                return cb.equal(join.get("id"), tagId);
            }
        }, pageable);
    }

    @Override
    public Page<Blog> listBlog(String query, Pageable pageable) {
        return blogRepository.findByQuery(query, pageable);
    }
    @Override
    public List<Blog> listRecommendBlogTop(Integer size) {
        // 使用Sort.by静态方法创建Sort对象
        Sort sort = Sort.by(Sort.Direction.DESC, "updateTime");
        // 使用PageRequest.of静态方法创建Pageable对象
        Pageable pageable = PageRequest.of(0, size, sort);
        return blogRepository.findTop(pageable);
    }
//    @Override
//    public List<Blog> listRecommendBlogTop(Integer size) {
//        Sort sort = new Sort(Sort.Direction.DESC, "updateTime");
//        Pageable pageable = new PageRequest(0, size, sort);
//        return blogRepository.findTop(pageable);
//    }

    @Override
    public Map<String, List<Blog>> archiveBlog() {
        List<String> years = blogRepository.findGroupYear();
        Map<String, List<Blog>> map = new HashMap<>();
        for (String year : years) {
            map.put(year, blogRepository.findByYear(year));
        }
        return map;
    }

    @Override
    public Long countBlog() {
        return blogRepository.count();
    }


    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        if (blog.getId() == null) {
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
        } else {
            blog.setUpdateTime(new Date());
        }
        return blogRepository.save(blog);
    }

    @Transactional
    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog b = blogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("该博客不存在"));
        // 使用自定义工具类来排除null值的属性
        BeanUtils.copyProperties(blog, b, MyBeanUtils.getNullPropertyNames(blog));
        b.setUpdateTime(new Date()); // 更新修改时间
        return blogRepository.save(b); // 保存并返回更新后的实体
    }


    @Transactional
    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
