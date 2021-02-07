package com.example.dlxrabbitmqdemo.consumer;

import com.example.dlxrabbitmqdemo.config.RabbitConfigDemo02;
import com.example.dlxrabbitmqdemo.entity.DemoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfigDemo02.DEAD_QUEUE)
public class DlxConsumer02 {

    private Logger logger = LoggerFactory.getLogger(DlxConsumer02.class);

    @RabbitHandler
    public void onMessage(DemoMessage demoMessage) {
        logger.info("消费者消费达到队列最大长度后的死信消息 [onMessage][线程编号：{}，消息内容：{}]",
                Thread.currentThread().getId(), demoMessage);
    }
}
