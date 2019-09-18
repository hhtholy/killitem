package com.hht.server.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author hht
 * @create 2019-09-18 16:13
 */
@Service
public class RabbitMqServiceSend {

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;

    /**
     * 秒杀结束后 发送  邮件消息
     */
    public void sendEmail(String orderNo) throws UnsupportedEncodingException {
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//        rabbitTemplate.setExchange(env.getProperty("mq.kill.item.success.email.exchange"));
//        rabbitTemplate.setRoutingKey(env.getProperty("mq.kill.item.success.email.routing.key"));
//        Message message = MessageBuilder.withBody(orderNo.getBytes("utf-8")).build();
//        rabbitTemplate.convertAndSend(message);


//        rabbitTemplate.convertAndSend(info, new MessagePostProcessor() {
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                MessageProperties messageProperties=message.getMessageProperties();
//                messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
//                messageProperties.setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, KillSuccessUserInfo.class);
//                return message;
//            }
//        });
    }


}
