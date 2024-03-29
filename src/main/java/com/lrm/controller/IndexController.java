package com.lrm.controller;
import com.lrm.dto.BlogListDTO;
import com.lrm.dto.TagListDTO;
import com.lrm.dto.TypeDTO;
import com.lrm.dto.TypeListDTO;
import com.lrm.po.Blog;
import com.lrm.po.Tag;
import com.lrm.po.Type;
import com.lrm.service.BlogService;
import com.lrm.service.TagService;
import com.lrm.service.TypeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @CircuitBreaker(name = "blogBreaker")
    @GetMapping("/blogsIndex")
    public ResponseEntity<Page<BlogListDTO>> getBlogs(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(blogService.listBlog(pageable));
    }
    @GetMapping("/typesIndex")
    public ResponseEntity<List<TypeListDTO>> getCategories() {
        List<TypeListDTO> typeListDTO = typeService.listTypeTop(6);
        return ResponseEntity.ok(typeListDTO);
    }

    @GetMapping("/tagsIndex")
    public ResponseEntity<List<TagListDTO>> getTags() {
        List<TagListDTO> tags = tagService.listTagTop(10);
        return ResponseEntity.ok(tags);
    }

    @GetMapping("/recommendBlogsIndex")
    public ResponseEntity<List<Blog>> getRecommendBlogs() {
        return ResponseEntity.ok(blogService.listRecommendBlogTop(8));
    }
    @PostMapping("/search")
    public String search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, Model model) {
        model.addAttribute("page", blogService.listBlog("%"+query+"%", pageable));
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model) {
        model.addAttribute("blog", blogService.getAndConvert(id));
        return "blog";
    }

    @GetMapping("/footer/newblog")
    public String newblogs(Model model) {
        model.addAttribute("newblogs", blogService.listRecommendBlogTop(3));
        return "_fragments :: newblogList";
    }

}
