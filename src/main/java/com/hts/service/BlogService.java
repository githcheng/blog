package com.hts.service;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hts.entity.Blog;
import com.hts.mapper.BlogDAO;


/**
 * Created by jam on 2017/2/9.
 */
@Service
public class BlogService {

    private static Logger logger = LoggerFactory.getLogger(BlogService.class);

    @Autowired
    private BlogDAO blogDAO;

    public int addBlog(Blog blog){
        return blogDAO.insert(blog);
    }

    public Blog getBlogById(String id){
        return blogDAO.getBlogById(id);
    }

    public int update(Blog blog) {
        return blogDAO.update(blog);
    }

    public List<Blog> getBlogList(long offset, long limit, String sort) {
        return blogDAO.getBlogList(offset,limit,sort);
    }
}
