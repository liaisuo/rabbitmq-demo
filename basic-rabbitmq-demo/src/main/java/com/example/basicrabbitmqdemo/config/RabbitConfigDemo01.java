package com.example.basicrabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigDemo01 {
    /**
     * 交换器名称
     */
    public static final String EXCHANGE = "exchange_demo01";

    /**
     * 队列名称
     */
    public static final String QUEUE = "queue_demo01";

    /**
     * 路由键名称
     */
    public static final String ROUTING_KEY = "routing_key_demo01";

    /**
     * 交换器
     */
    @Bean
    public DirectExchange demo01Exchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }

    /**
     * 队列
     */
    @Bean
    public Queue demo01Queue() {
        return new Queue(QUEUE, true, false, false);
    }

    /**
     * 交换器与队列绑定
     */
    @Bean
    public Binding demo01Binding() {
        return BindingBuilder.bind(demo01Queue()).to(demo01Exchange()).with(ROUTING_KEY);
    }
}
