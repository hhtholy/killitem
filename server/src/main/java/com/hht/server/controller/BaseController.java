package com.hht.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hht
 * @create 2019-09-16 17:17
 */
@Controller
public class BaseController {


    @GetMapping(value = "/error")
    public String error(){
        return "error";
    }

}
