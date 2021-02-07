package com.example.txrabbitmqdemo.service.impl;

import com.example.txrabbitmqdemo.config.RabbitConfigDemo01;
import com.example.txrabbitmqdemo.controller.TxController;
import com.example.txrabbitmqdemo.entity.DemoMessage;
import com.example.txrabbitmqdemo.service.TxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxServiceImpl implements TxService {

    private Logger logger = LoggerFactory.getLogger(TxServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void demo01SyncSendTx(DemoMessage demoMessage) {
        logger.info("发送事务消息，消息内容：{}", demoMessage);
        rabbitTemplate.convertAndSend(RabbitConfigDemo01.EXCHANGE,
                RabbitConfigDemo01.ROUTING_KEY, demoMessage);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
