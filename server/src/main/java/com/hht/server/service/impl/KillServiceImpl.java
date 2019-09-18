package com.hht.server.service.impl;

import com.hht.model.entity.ItemKill;
import com.hht.model.entity.ItemKillSuccess;
import com.hht.model.mapper.ItemKillMapper;
import com.hht.model.mapper.ItemKillSuccessMapper;
import com.hht.server.enums.SysConstant;
import com.hht.server.service.KillService;
import com.hht.server.utils.SnowFlake;
import org.joda.time.DateTime;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author hht
 * @create 2019-09-16 17:22
 */
@Service
public class KillServiceImpl implements KillService {


    @Autowired
    private ItemKillMapper itemKillMapper;

    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;

    private SnowFlake snowFlake=new SnowFlake(2,3);



//    @Autowired
//    private RabbitMqServiceSend rabbitMqServiceSend;


    @Override
    public Boolean killItem(Integer killId, Integer userId) {
        Boolean result = false;
        int count = itemKillSuccessMapper.countByKillUserId(killId, userId);
        if(count == 0){ //判断是不是已经抢购过  没有抢购过的情况
            //查看商品详情  判断是不是可以抢购
            ItemKill itemKill = itemKillMapper.selectById(killId);
            //如果说可以秒杀
            if(itemKill != null && itemKill.getCanKill().equals(1)){
                //库存减1
                int res = itemKillMapper.updateKillItem(killId);
                if(res != 0){ //成功
                    result = true;
                    try {
                        createOrderAndSendMsg(itemKill,userId);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
        return result;
    }
    //创建订单
    public void createOrderAndSendMsg(ItemKill itemKill,Integer userId) throws UnsupportedEncodingException {
        ItemKillSuccess itemKillSuccess = new ItemKillSuccess();
        itemKillSuccess.setCode(String.valueOf(snowFlake.nextId()));
        itemKillSuccess.setItemId(itemKill.getItemId());
        itemKillSuccess.setKillId(itemKill.getId());
        itemKillSuccess.setUserId(userId.toString());
        itemKillSuccess.setStatus(SysConstant.OrderStatus.SuccessNotPayed.getCode().byteValue());
        itemKillSuccess.setCreateTime(DateTime.now().toDate());
        //插入订单记录
        int res = itemKillSuccessMapper.insertSelective(itemKillSuccess);
        if(res != 0){  //创建订单成功
         //发送消息
            //rabbitMqServiceSend.sendEmail(itemKillSuccess.getCode());
        }
    }


}
