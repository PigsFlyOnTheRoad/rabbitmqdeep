package com.example.rabbitmqdeep.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName HelloConsumer
 * @Description TODO
 * @Author cailun
 */
@Component   //监听哪一个队列                                    是否持久化，是否自动删除

public class HelloConsumer {

    //消费者的回调
    @RabbitListener(queuesToDeclare = @Queue(value = "hello",autoDelete = "true",durable = "false"))
    public void receive(String message){

        System.out.println(message);

    }

}
