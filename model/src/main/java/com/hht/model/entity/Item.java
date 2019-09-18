package com.hht.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hht
 * @create 2019-08-30 15:19
 */
@Data
public class Item {
    private Integer id;

    private String name;

    private String code;

    private Long stock;

    private Date purchaseTime;

    private Integer isActive;

    private Date createTime;

    private Date updateTime;

}
