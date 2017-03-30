package com.hts.controller;

import com.hts.entity.Blog;
import com.hts.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by jam on 2016/12/22.
 */
@Controller
@RequestMapping("")
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private BlogService blogService;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        ModelAndView model = new ModelAndView("list");

        long offset = 0L;
        long limit = 20L;
        String sort = "desc";

        List<Blog> blogList = blogService.getBlogList(offset,limit,sort);
        model.getModel().put("blogList",blogList);
        return model;
    }
}
