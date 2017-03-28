package com.hts.controller;

import com.alibaba.fastjson.JSON;
import com.hts.entity.Blog;
import com.hts.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by jam on 2016/12/22.
 */
@Controller
@RequestMapping("")
public class ArticleController {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private BlogService blogService;
    
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public ModelAndView sayWorld(
            @RequestParam String id,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        ModelAndView model = new ModelAndView("article");


        System.out.println("id="+id);
        Blog blog = blogService.getBlogById(id);
        logger.info("blog:{}", JSON.toJSON(blog));
        model.getModel().put("title",blog.getTitle());
        model.getModel().put("markdownContent",blog.getHtml());
        return model;
    }
}
