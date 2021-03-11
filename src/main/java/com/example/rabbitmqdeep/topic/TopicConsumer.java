package com.example.rabbitmqdeep.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName TopicConsumer
 * @Description 动态路由，比静态路由多一个通用匹配符
 * @Author cailun
 */
@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue ,//临时队列
                    exchange = @Exchange(value = "topic",type = "topic"),  //name,value 效果一样
                    key = {"topicKey.#"}   //#代表零或者多位，*代表一位
            )
    })
    public void topicConsumer1(String message){

        System.out.println("message1  " + message);

    }

}
