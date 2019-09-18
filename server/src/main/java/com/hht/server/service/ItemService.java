package com.hht.server.service;

import com.hht.model.entity.Item;
import com.hht.model.entity.ItemKill;

import java.util.List;

/**
 * @author hht
 * @create 2019-09-16 15:21
 */
public interface ItemService {
    public List<ItemKill> getItemKillList();
    public ItemKill getItemKillDetail(Integer id);
}
