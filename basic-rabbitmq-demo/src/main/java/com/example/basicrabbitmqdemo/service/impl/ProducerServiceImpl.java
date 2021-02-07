package com.example.basicrabbitmqdemo.service.impl;

import com.example.basicrabbitmqdemo.config.RabbitConfigDemo01;
import com.example.basicrabbitmqdemo.config.RabbitConfigDemo02;
import com.example.basicrabbitmqdemo.config.RabbitConfigDemo03;
import com.example.basicrabbitmqdemo.entity.DemoMessage;
import com.example.basicrabbitmqdemo.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void demo01SyncSend(DemoMessage demoMessage) {
        logger.info("direct交换器，发送消息内容：{}", demoMessage);
        rabbitTemplate.convertAndSend(RabbitConfigDemo01.EXCHANGE, RabbitConfigDemo01.ROUTING_KEY, demoMessage);
    }

    @Override
    public void demo02SyncSend(DemoMessage demoMessage) {
        logger.info("fanout交换器，发送消息内容：{}", demoMessage);
        rabbitTemplate.convertAndSend(RabbitConfigDemo02.EXCHANGE, null, demoMessage);
    }

    @Override
    public void demo03SyncSend(DemoMessage demoMessage) {
        logger.info("topic交换器，发送消息内容：{}", demoMessage);
        rabbitTemplate.convertAndSend(RabbitConfigDemo03.EXCHANGE, "test.summer.key.demo03", demoMessage);
    }
}
