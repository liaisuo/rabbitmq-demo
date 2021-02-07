package com.example.dlxrabbitmqdemo.service;

import com.example.dlxrabbitmqdemo.entity.DemoMessage;

public interface DlxService {
    void demo01SyncSendTtl(DemoMessage demoMessage);

    void demo02SyncSendMaxLength(DemoMessage demoMessage);
}
