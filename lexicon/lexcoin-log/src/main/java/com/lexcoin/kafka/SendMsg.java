package com.lexcoin.kafka;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.annotation.TopicPartition;

import java.lang.annotation.*;

/**
 * kafka 发送消息注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface SendMsg {

    String topics() default "";

    /**
     * 这个属性目前未实现
     * @return
     */
    TopicPartition[] topicPartitions() default {};

    String groupId() default "";



}
