package com.example.rabbitmqdeep.rounte;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName RouteDiect
 * @Description 路由直连模式，
 * 特性：比广播模式多一个routekey，可以分配路由积极性选择消息队列（同时执行）
 * @Author cailun
 */
@Component
public class RouteDiect {

    @RabbitListener(bindings = {

            @QueueBinding(
                    value = @Queue,//临时队列
                    exchange = @Exchange(value = "routKey",type = "direct"), //交换机名称,类型（direct）默认
                    key = {"routDirect"}  //路由key（routekey）

            )
    })
    public void routeDirect1(String message){

        System.out.println("message1  " + message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 临时队列
                    exchange = @Exchange(value = "routKey", type = "direct"), // 绑定交换机，type默认direct
                    key = {"routDirect"} //路由key
            )
    }

    )
    public void routeDirect2(String message) {
        System.out.println("message2  " + message);
    }


}
