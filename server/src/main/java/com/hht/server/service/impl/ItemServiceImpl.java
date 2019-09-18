package com.hht.server.service.impl;

import com.hht.model.entity.Item;
import com.hht.model.entity.ItemKill;
import com.hht.model.mapper.ItemKillMapper;
import com.hht.model.mapper.ItemMapper;
import com.hht.server.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hht
 * @create 2019-09-16 15:21
 */
@Service
public class ItemServiceImpl implements ItemService {

    private Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);


    @Autowired
    private ItemKillMapper itemKillMapper;


    @Override
    public List<ItemKill> getItemKillList() {
        try {
            return itemKillMapper.selectAll();
        }catch (Exception e){
            logger.error("出现异常",e);
        }
        return null;
    }

    @Override
    public ItemKill getItemKillDetail(Integer id) {
        return itemKillMapper.selectById(id);
    }
}
