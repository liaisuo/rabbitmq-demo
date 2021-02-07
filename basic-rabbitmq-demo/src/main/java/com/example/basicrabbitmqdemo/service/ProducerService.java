package com.example.basicrabbitmqdemo.service;

import com.example.basicrabbitmqdemo.entity.DemoMessage;

public interface ProducerService {
    void demo01SyncSend(DemoMessage demoMessage);

    void demo02SyncSend(DemoMessage demoMessage);

    void demo03SyncSend(DemoMessage demoMessage);
}
