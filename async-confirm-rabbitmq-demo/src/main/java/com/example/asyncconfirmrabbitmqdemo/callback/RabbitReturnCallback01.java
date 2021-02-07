package com.example.asyncconfirmrabbitmqdemo.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitReturnCallback01 implements RabbitTemplate.ReturnsCallback {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public RabbitReturnCallback01(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setReturnsCallback(this);
    }

    @Override
    public void returnedMessage(ReturnedMessage returned) {
        logger.info("退回消息，[线程编号：{},退回信息：{}]",
                Thread.currentThread().getId(), returned);
    }
}
