package com.example.basicrabbitmqdemo.consumer;

import com.example.basicrabbitmqdemo.config.RabbitConfigDemo02;
import com.example.basicrabbitmqdemo.entity.DemoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfigDemo02.QUEUE_B)
public class Demo02ConsumerB {

    private Logger logger = LoggerFactory.getLogger(Demo02ConsumerB.class);

    @RabbitHandler
    public void onMessage(DemoMessage demoMessage) {
        logger.info("fanout交换器，消费者B [onMessage][线程编号：{},消息内容：{}]",
                Thread.currentThread().getId(), demoMessage);
    }
}
