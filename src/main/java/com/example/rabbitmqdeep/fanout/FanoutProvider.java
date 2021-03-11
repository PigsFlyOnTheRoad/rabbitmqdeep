package com.example.rabbitmqdeep.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FanoutProvider
 * @Description 广播消费模型  -特性，routingkey在广播模型中不起作用，一个交换机分配多个消息队列
 *                  多个队列（同时执行）
 * @Author cailun
 */
@Component
public class FanoutProvider {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //创建临时队列
                    exchange = @Exchange("logs")//绑定交换机
            )}) public void fanoutConsumer1(String message) { System.out.println("fountout1  " + message);

    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue ,//创建临时交换机
                    exchange = @Exchange("logs")//绑定交换机名称
            )
    })
    public void fanoutConsumer2(String message){

        System.out.println("fountout2 " + message);
    }


}
