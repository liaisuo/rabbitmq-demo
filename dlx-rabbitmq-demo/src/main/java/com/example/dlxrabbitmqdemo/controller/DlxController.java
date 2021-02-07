package com.example.dlxrabbitmqdemo.controller;

import com.example.dlxrabbitmqdemo.entity.DemoMessage;
import com.example.dlxrabbitmqdemo.service.DlxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DlxController {

    private Logger logger = LoggerFactory.getLogger(DlxController.class);

    @Autowired
    private DlxService dlxService;

    /**
     * 消息TTL过期
     */
    @PostMapping("/demo01SyncSendTtl")
    public void demo01SyncSendTtl(@RequestBody DemoMessage demoMessage) {
        try {
            dlxService.demo01SyncSendTtl(demoMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 达到队列最大长度的DLX
     */
    @PostMapping("/demo02SyncSendMaxLength")
    public void demo02SyncSendMaxLength(@RequestBody DemoMessage demoMessage) {
        try {
            dlxService.demo02SyncSendMaxLength(demoMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
