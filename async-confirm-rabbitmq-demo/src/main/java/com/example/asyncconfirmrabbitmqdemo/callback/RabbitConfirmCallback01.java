package com.example.asyncconfirmrabbitmqdemo.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * rabbitmq broker确认消息的回调方法
 */
@Component
public class RabbitConfirmCallback01 implements RabbitTemplate.ConfirmCallback {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public RabbitConfirmCallback01(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            logger.info("发送消息确认成功，线程编号：{},correlationData：{}",
                    Thread.currentThread().getId(), correlationData);
        } else {
            logger.info("发送消息确认失败，线程编号：{},correlationData：{}，cause：{}",
                    Thread.currentThread().getId(), correlationData, cause);
        }
    }
}
