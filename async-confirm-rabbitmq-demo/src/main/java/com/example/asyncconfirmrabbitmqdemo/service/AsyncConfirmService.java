package com.example.asyncconfirmrabbitmqdemo.service;

import com.example.asyncconfirmrabbitmqdemo.entity.DemoMessage;

public interface AsyncConfirmService {
    void asyncConfirmSendMsgDemo01(DemoMessage demoMessage);

    void returnCallbackSendMsgDemo01(DemoMessage demoMessage);
}
