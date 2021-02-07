package com.example.basicrabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigDemo03 {
    /**
     * 交换器名称
     */
    public static final String EXCHANGE = "exchange_demo03";

    /**
     * 队列名称
     */
    public static final String QUEUE = "queue_demo03";

    /**
     * 模糊匹配路由键
     */
    public static final String ROUTING_KEY = "#.key.demo03";

    /**
     * 交换器
     */
    @Bean
    public TopicExchange demo03Exchange() {
        return new TopicExchange(EXCHANGE, true, false);
    }

    /**
     * 队列
     */
    @Bean
    public Queue demo03Queue() {
        return new Queue(QUEUE, true, false, false);
    }

    /**
     * 交换器与队列绑定
     */
    @Bean
    public Binding demo03Binding() {
        return BindingBuilder.bind(demo03Queue()).to(demo03Exchange()).with(ROUTING_KEY);
    }
}
