package com.example.asyncconfirmrabbitmqdemo.controller;

import com.example.asyncconfirmrabbitmqdemo.entity.DemoMessage;
import com.example.asyncconfirmrabbitmqdemo.service.AsyncConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步confirm模式
 */
@RestController
public class AsyncConfirmController {

    @Autowired
    private AsyncConfirmService asyncConfirmService;

    @PostMapping("/asyncConfirmSendMsgDemo01")
    public void asyncConfirmSendMsgDemo01(@RequestBody DemoMessage demoMessage) {
        asyncConfirmService.asyncConfirmSendMsgDemo01(demoMessage);
    }

    @PostMapping("/returnCallbackSendMsgDemo01")
    public void returnCallbackSendMsgDemo01(@RequestBody DemoMessage demoMessage) {
        asyncConfirmService.returnCallbackSendMsgDemo01(demoMessage);
    }
}
