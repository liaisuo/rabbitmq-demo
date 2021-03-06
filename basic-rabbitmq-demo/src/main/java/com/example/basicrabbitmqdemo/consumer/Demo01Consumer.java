package com.example.basicrabbitmqdemo.consumer;

import com.example.basicrabbitmqdemo.config.RabbitConfigDemo01;
import com.example.basicrabbitmqdemo.entity.DemoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfigDemo01.QUEUE)
public class Demo01Consumer {

    private Logger logger = LoggerFactory.getLogger(Demo01Consumer.class);

    @RabbitHandler
    public void onMessage(DemoMessage demoMessage) {
        logger.info("消费消息[onMessage][线程编号：{}，消息内容：{}]",
                Thread.currentThread().getId(), demoMessage);
    }

}
