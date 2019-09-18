package com.hht.server.controller;

import com.hht.model.entity.ItemKill;
import com.hht.server.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * @author hht
 * @create 2019-09-16 15:16
 */
@Controller
public class ItemController {

    private Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;


    /*查看详情列表*/
    @GetMapping(value = {"/","/list"})
    public String getItemKillList(ModelMap modelMap){
        try {
            List<ItemKill> itemKillList = itemService.getItemKillList();
            modelMap.put("list",itemKillList);
            logger.info("获取的数据,list={}",itemKillList);
        }catch (Exception e){
            logger.error("出现异常",e);
        }
        return "list";
    }


  /*查看商品详情*/
    @GetMapping(value = "/item_detail/{id}")
    public String getItemKillDetail(@PathVariable Integer id,ModelMap modelMap){
        try {
            ItemKill itemKillDetail = itemService.getItemKillDetail(id);
            logger.info("获取的数据,detail={}",itemKillDetail);
            modelMap.put("detail",itemKillDetail);
        }catch (Exception e){
            logger.error("出现异常",e);
        }
        return "info";
    }

}
