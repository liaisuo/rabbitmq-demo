package com.example.dlxrabbitmqdemo.consumer;

import com.example.dlxrabbitmqdemo.config.RabbitConfigDemo01;
import com.example.dlxrabbitmqdemo.entity.DemoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听死信队列
 */
@Component
@RabbitListener(queues = RabbitConfigDemo01.DEAD_QUEUE)
public class DlxConsumer01 {

    private Logger logger = LoggerFactory.getLogger(DlxConsumer01.class);

    @RabbitHandler
    public void onMessage(DemoMessage demoMessage) {
        logger.info("消费者消费TTL过期消息 [onMessage][线程编号：{}，消息内容：{}]",
                Thread.currentThread().getId(), demoMessage);
    }
}
