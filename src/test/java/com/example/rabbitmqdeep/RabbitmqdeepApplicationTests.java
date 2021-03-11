package com.example.rabbitmqdeep;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqdeepApplicationTests {


    @Autowired
    private RabbitTemplate rabbitTemplate;
    //并非在生产者中创建
    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    @Test  //工作队列
    void work(){

        rabbitTemplate.convertAndSend("work","work world");
    }
    @Test
    void fanout(){
        //交换机名称，广播模式路由key不起作用，所以不必配置
        rabbitTemplate.convertAndSend("logs","","fanout type hello world");
    }

    @Test
    void routingDirect(){  //静态路由模式。比广播模式多了一个routingkey

        rabbitTemplate.convertAndSend("routKey","routDirect","routingDirect");
    }

    @Test
    void topic(){   //动态路由，比静态路由多一个通用匹配符

        rabbitTemplate.convertSendAndReceive("topic","topicKey","routingTopic");
    }



}
