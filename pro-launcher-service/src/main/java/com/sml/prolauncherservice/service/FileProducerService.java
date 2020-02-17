package com.sml.prolauncherservice.service;

//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessageBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileProducerService {

//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    @Value("${jsa.rabbitmq.exchange}")
//    private String exchange;
//
//    @Value("${jsa.rabbitmq.routingkey}")
//    private String routingKey;
//
//    public void produceMsg(String msg){
//        amqpTemplate.convertAndSend(exchange, routingKey, msg);
//        System.out.println("Send msg = " + msg);
//    }
//
//    public void sendFile(byte[] content){
//        Message message = MessageBuilder.withBody(content).setHeader("ContentType", true).build();
//        amqpTemplate.convertAndSend(exchange, routingKey, message);
//        System.out.println("Message has been sent.");
//    }
}
