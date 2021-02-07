package com.example.dlxrabbitmqdemo.service.impl;

import com.example.dlxrabbitmqdemo.config.RabbitConfigDemo01;
import com.example.dlxrabbitmqdemo.config.RabbitConfigDemo02;
import com.example.dlxrabbitmqdemo.entity.DemoMessage;
import com.example.dlxrabbitmqdemo.service.DlxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DlxServiceImpl implements DlxService {

    private Logger logger = LoggerFactory.getLogger(DlxServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void demo01SyncSendTtl(DemoMessage demoMessage) {
        logger.info("发送消息的内容：{}", demoMessage);
        rabbitTemplate.convertAndSend(RabbitConfigDemo01.EXCHANGE,
                RabbitConfigDemo01.ROUTING_KEY, demoMessage);
    }

    @Override
    public void demo02SyncSendMaxLength(DemoMessage demoMessage) {
        logger.info("发送消息的内容：{}", demoMessage);
        rabbitTemplate.convertAndSend(RabbitConfigDemo02.EXCHANGE,
                RabbitConfigDemo02.ROUTING_KEY, demoMessage);
    }
}
