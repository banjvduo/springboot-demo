package com.banjvduo.demo.controller;

import com.banjvduo.demo.exception.DemoException;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "HelloController", description = "hi~~")
@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(Model map) {
        map.addAttribute("des", "des:Hello World");
        return "index";
    }

    @RequestMapping(value = "/defaultError")
    public String defaultError() throws Exception {
        throw new Exception("一个错误");
    }

    @RequestMapping(value = "/jsonError")
    public String jsonError() throws Exception {
        throw new DemoException("一个错误");
    }
}
