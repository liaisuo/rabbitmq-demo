package com.example.basicrabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigDemo02 {

    public static final String EXCHANGE = "exchange_demo02";

    public static final String QUEUE_A = "queue_demo02_A";

    public static final String QUEUE_B = "queue_demo02_B";

    /**
     * 交换器
     */
    @Bean
    public FanoutExchange demo02Exchange() {
        return new FanoutExchange(EXCHANGE, true, false);
    }

    /**
     * 队列A
     */
    @Bean
    public Queue demo02QueueA() {
        return new Queue(QUEUE_A, true, false, false);
    }

    /**
     * 队列B
     */
    @Bean
    public Queue demo02QueueB() {
        return new Queue(QUEUE_B, true, false, false);
    }

    /**
     * 交换器绑定队列A
     */
    @Bean
    public Binding demo02BindingQueueA() {
        return BindingBuilder.bind(demo02QueueA()).to(demo02Exchange());
    }

    /**
     * 交换器绑定队列B
     */
    @Bean
    public Binding demo02BindingQueueB() {
        return BindingBuilder.bind(demo02QueueB()).to(demo02Exchange());
    }
}
