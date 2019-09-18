package com.hht.server.controller;

import com.hht.api.BaseResponse;
import com.hht.api.StatusCode;
import com.hht.server.dto.KillDto;
import com.hht.server.service.KillService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hht
 * @create 2019-09-16 17:20
 */
@Controller
@Api(tags = "秒杀相关")
public class KillController {


    private Logger logger = LoggerFactory.getLogger(KillController.class);

    @Autowired
    private KillService killService;


    //商品秒杀
    @PostMapping("/killitem")
    @ResponseBody
    public BaseResponse excute(@RequestBody @Validated KillDto killDto, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors() || killDto.getKillId() <= 0){
            return new BaseResponse(StatusCode.InvalidParams);  //非法参数
        }
        try {
            Boolean res = killService.killItem(killDto.getKillId(), killDto.getUserId());
            if(!res){ //抢购失败
                return new BaseResponse(StatusCode.Fail.getCode(),"已经抢购过");
            }
        }catch (Exception e){
            logger.error("秒杀出现异常",e);
            throw  new Exception("出现错误");
        }
        //抢购成功
        return new BaseResponse(StatusCode.Success);
    }




}
