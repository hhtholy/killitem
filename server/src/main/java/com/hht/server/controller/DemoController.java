package com.hht.server.controller;

/**
 * @author hht
 * @create 2019-09-16 10:50
 */

import com.hht.api.BaseResponse;
import com.hht.model.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("base")
public class DemoController {

    @Autowired
    private ItemMapper itemMapper;


    @GetMapping("/wel")
    public String demo(){
        return "welcome";
    }

    @GetMapping("/demo")
    @ResponseBody
    public BaseResponse demo1(){
        return new BaseResponse(1,"12",null);
    }

}
