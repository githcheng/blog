package com.hts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jam on 2016/12/22.
 */
@Controller
@RequestMapping("")
public class EditController {

    @RequestMapping(value = "/edit", method = {RequestMethod.GET,RequestMethod.POST})
    public String index() {
        return "edit";
    }
}
