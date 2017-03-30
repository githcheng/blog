package com.hts.controller;

import com.alibaba.fastjson.JSON;
import com.hts.entity.Blog;
import com.hts.service.BlogService;
import org.apache.commons.lang.StringUtils;
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
public class EditController {

    private final static Logger logger = LoggerFactory.getLogger(EditController.class);

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/edit", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView index(@RequestParam("id") String id, HttpServletRequest request,
                        HttpServletResponse response) {

        ModelAndView model = new ModelAndView("edit");

        if (StringUtils.isBlank(id)){
            logger.info("id:{}",id);
            return model;
        }
        Blog blog = blogService.getBlogById(id);

        if (blog == null){
            return model;
        }
        logger.info("blog:{}", JSON.toJSON(blog));
        model.getModel().put("id",blog.getId());
        model.getModel().put("uniq",blog.getUniq());
        model.getModel().put("title",blog.getTitle());
        model.getModel().put("markdownContent",blog.getMarkdown());
        return model;
    }
}
