package com.hts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jam on 2016/12/22.
 */
@Controller
@RequestMapping("/learn")
public class PageLearnController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String sayWorld(@PathVariable("name") String name) {
        return name;
    }
}
