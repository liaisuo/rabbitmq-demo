package com.example.basicrabbitmqdemo.controller;

import com.example.basicrabbitmqdemo.entity.DemoMessage;
import com.example.basicrabbitmqdemo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    /**
     * direct交换器
     */
    @PostMapping("/demo01SyncSend")
    public void demo01SyncSend(@RequestBody DemoMessage demoMessage) {
        try {
            producerService.demo01SyncSend(demoMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * fanout交换器
     */
    @PostMapping("/demo02SyncSend")
    public void demo02SyncSend(@RequestBody DemoMessage demoMessage) {
        try {
            producerService.demo02SyncSend(demoMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * topic交换器
     */
    @PostMapping("/demo03SyncSend")
    public void demo03SyncSend(@RequestBody DemoMessage demoMessage) {
        try {
            producerService.demo03SyncSend(demoMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
