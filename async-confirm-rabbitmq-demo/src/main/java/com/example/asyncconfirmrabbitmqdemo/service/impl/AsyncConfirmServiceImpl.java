package com.example.asyncconfirmrabbitmqdemo.service.impl;

import com.example.asyncconfirmrabbitmqdemo.config.RabbitConfigDemo01;
import com.example.asyncconfirmrabbitmqdemo.entity.DemoMessage;
import com.example.asyncconfirmrabbitmqdemo.service.AsyncConfirmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsyncConfirmServiceImpl implements AsyncConfirmService {

    private Logger logger = LoggerFactory.getLogger(AsyncConfirmServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void asyncConfirmSendMsgDemo01(DemoMessage demoMessage) {
        logger.info("发送确认消息，消息内容：{}", demoMessage);
        CorrelationData correlationData = new CorrelationData();
        // 设置消息唯一id编号
        correlationData.setId("100");
        rabbitTemplate.convertAndSend(RabbitConfigDemo01.EXCHANGE,
                RabbitConfigDemo01.ROUTING_KEY, demoMessage, correlationData);
    }

    @Override
    public void returnCallbackSendMsgDemo01(DemoMessage demoMessage) {
        logger.info("发送退回的消息，消息内容：{}", demoMessage);
        CorrelationData correlationData = new CorrelationData();
        // 设置消息唯一id编号
        correlationData.setId("200");
        rabbitTemplate.convertAndSend(RabbitConfigDemo01.EXCHANGE,
                "testRoutingKeyNotExist", demoMessage, correlationData);
    }
}
