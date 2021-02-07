package com.example.dlxrabbitmqdemo.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfigDemo02 {

    public static final String EXCHANGE = "exchange_demo02";

    public static final String QUEUE = "queue_demo02";

    public static final String ROUTING_KEY = "routing_key_demo02";

    public static final String DEAD_EXCHANGE = "dead_exchange_demo02";

    public static final String DEAD_QUEUE = "dead_queue_demo02";

    public static final String DEAD_ROUTING_KEY = "dead_routing_key_demo02";

    @Bean
    public DirectExchange demo02Exchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }

    @Bean
    public Queue demo02Queue() {
        Map<String, Object> params = new HashMap<>(8);
        // 设置队列的最大长度值为0
        params.put("x-max-length", 0);
        // 设置死信交换器
        params.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        // 设置死信交换器路由键
        params.put("x-dead-letter-routing-key", DEAD_ROUTING_KEY);

        return new Queue(QUEUE, true, false, false, params);
    }

    @Bean
    public Binding demo02Binding() {
        return BindingBuilder.bind(demo02Queue()).to(demo02Exchange()).with(ROUTING_KEY);
    }

    /**
     * 死信交换器
     */
    @Bean
    public DirectExchange demo02DeadExchange() {
        return new DirectExchange(DEAD_EXCHANGE, true, false);
    }

    /**
     * 死信队列
     */
    @Bean
    public Queue demo02DeadQueue() {
        return new Queue(DEAD_QUEUE, true, false, false);
    }

    /**
     * 死信交换器与死信队列绑定
     */
    @Bean
    public Binding demo02DeadBinding() {
        return BindingBuilder.bind(demo02DeadQueue()).to(demo02DeadExchange()).with(DEAD_ROUTING_KEY);
    }
}
