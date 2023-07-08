package com.tapan.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogpost")
public class BlogPostController {
    @GetMapping("/list")
    public String list() {
        return "blogpost/list";
    }

    @PostMapping("/create")
    public String create() {
        return "blogpost/create";
    }

    @GetMapping("/edit")
    public String edit() {
        return "blogpost/edit";
    }

    @GetMapping("/{id}")
    public String getPostById(@PathVariable Integer id){
        return "blogpost/getPostById:" + id;
    }
}
