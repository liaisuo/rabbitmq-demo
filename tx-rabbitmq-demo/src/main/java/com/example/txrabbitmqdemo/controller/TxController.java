package com.example.txrabbitmqdemo.controller;

import com.example.txrabbitmqdemo.entity.DemoMessage;
import com.example.txrabbitmqdemo.service.TxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 事务消息控制器
 */
@RestController
public class TxController {

    private Logger logger = LoggerFactory.getLogger(TxController.class);

    @Autowired
    private TxService txService;

    @PostMapping("/demo01SyncSendTx")
    public void demo01SyncSendTx(@RequestBody DemoMessage demoMessage) {
        txService.demo01SyncSendTx(demoMessage);
    }
}
