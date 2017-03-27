package com.hts.controller;

import com.hts.entity.Blog;
import com.hts.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * Created by jam on 2016/12/22.
 */
@Controller
@RequestMapping("")
public class ReceiveDataController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value="/receive",method = RequestMethod.POST)
    public String sayWorld(
                           HttpServletRequest request,
                           HttpServletResponse response) {

        String html = request.getParameter("test-editormd-html-code");
        String markdown = request.getParameter("test-editormd-markdown-doc");

        System.out.println("receive");
        System.out.println("textarea: "+html);
        long cur = System.currentTimeMillis();
        String uniq = UUID.randomUUID().toString();
        String title = "";


        Blog blog = new Blog(uniq,title,markdown,html,cur,cur);
        int res = blogService.addBlog(blog);
        System.out.println("res:"+res);

        return "hw";
    }
}
