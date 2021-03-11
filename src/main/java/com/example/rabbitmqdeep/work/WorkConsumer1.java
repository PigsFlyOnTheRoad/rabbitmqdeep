package com.example.rabbitmqdeep.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName WorkConsumer
 * @Description 工作队列   ---特性，平均分配
 * @Author cailun
 */
@Component
public class WorkConsumer1 {

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void receive1(String message){

        System.out.println("message1"+message);

    }

}
