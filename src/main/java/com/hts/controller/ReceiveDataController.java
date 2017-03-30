package com.hts.controller;

import com.hts.entity.Blog;
import com.hts.service.BlogService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger logger = LoggerFactory.getLogger(ReceiveDataController.class);

    @Autowired
    private BlogService blogService;

    @RequestMapping(value="/receive",method = RequestMethod.POST)
    public String sayWorld(
                           HttpServletRequest request,
                           HttpServletResponse response) {

        String id = request.getParameter("id");
        String uniq = request.getParameter("uniq");
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String html = request.getParameter("test-editormd-html-code");
        String markdown = request.getParameter("test-editormd-markdown-doc");


        logger.info("{}|{}|{}|{}|{}|{}",id,uniq,title,type,html,markdown);
        long cur = System.currentTimeMillis();
        if (StringUtils.isBlank(uniq)){
            uniq = UUID.randomUUID().toString();
        }

        Blog blog = new Blog(uniq,title,markdown,html,cur,cur);

        int res = 0;
        if (StringUtils.isNotBlank(id)){
            blog.setId(Long.valueOf(id));
            res = blogService.update(blog);
            return "hw";
        }


        res = blogService.addBlog(blog);
        System.out.println("res:"+res);

        return "hw";
    }
}
