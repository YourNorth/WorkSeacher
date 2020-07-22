package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.dto.BlogPostDto;
import com.tenere_bufo.itis.model.Blog;
import com.tenere_bufo.itis.model.FileInfo;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.repository.BlogRepository;
import com.tenere_bufo.itis.security.details.UserDetailsImpl;
import com.tenere_bufo.itis.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    FileService fileService;

    @GetMapping("/create_blog")
    public String getCreateBlogPage(){
        return "create_blog";
    }

    @PostMapping("/create_blog")
    public String createBlogPost(BlogPostDto blogPostDto, @RequestParam("file") MultipartFile multipartFile, Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();

        Long pictureId;
        if (!multipartFile.isEmpty()) {
            Optional<FileInfo> optionalFileInfo = fileService.fileSave(multipartFile);
            pictureId = optionalFileInfo.get().getId();
        } else {
            pictureId = null;
            System.out.println("picture id is not present");
        }

        Date date=Calendar.getInstance().getTime();

        blogRepository.save(Blog.builder().name(blogPostDto.getPostName()).text(blogPostDto.getPostText()).user(user).picture_id(pictureId).date(date).build());

        return "redirect:/blog";
    }

    @GetMapping("/blog")
    public String getBlogPage(Model model){
        List<Blog> blogs = blogRepository.findAll();
        model.addAttribute("blogs",blogs);
        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String getBlockPageById(@PathVariable Long id, Model model) {
        try {
            Blog blog = blogRepository.findById(id).get();
            model.addAttribute("blog",blog);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return "single_blog";
    }

    @GetMapping("/single_blog")
    public String getSingleBlog(){
        return "single_blog";
    }
}
