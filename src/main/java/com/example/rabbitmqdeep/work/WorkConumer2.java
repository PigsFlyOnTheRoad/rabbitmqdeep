package com.example.rabbitmqdeep.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName WorkConumer
 * @Description 工作队列2--特性平均分配
 * @Author cailun
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "work"))
public class WorkConumer2 {


    public void recevice2(String message){

        System.out.println("message1"+ message);

    }
}

