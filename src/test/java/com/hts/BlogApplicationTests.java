package com.hts;

import com.alibaba.fastjson.JSON;
import com.hts.entity.Blog;
import com.hts.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BlogApplication.class)
@WebAppConfiguration
public class BlogApplicationTests {

	@Test
	public void contextLoads() {
	}

    @Autowired
    private BlogService blogService;

    @Test
    public void index() {
        long offset = 0L;
        long limit = 20L;
        String sort = "desc";

        List<Blog> blogList = blogService.getBlogList(offset,limit,sort);
        System.out.println(JSON.toJSON(blogList));
    }

}
