package com.example.txrabbitmqdemo.consumer;

import com.example.txrabbitmqdemo.config.RabbitConfigDemo01;
import com.example.txrabbitmqdemo.entity.DemoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfigDemo01.QUEUE)
public class ConsumerDemo01 {

    public Logger logger = LoggerFactory.getLogger(ConsumerDemo01.class);

    @RabbitHandler
    public void onMessage(DemoMessage demoMessage) {
        logger.info("消费事务消息 [onMessage][线程编号：{},消息内容：{}]",
                Thread.currentThread().getId(), demoMessage);
    }
}
