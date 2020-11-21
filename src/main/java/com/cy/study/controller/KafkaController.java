package com.cy.study.controller;

import com.cy.study.kafka.KafkaMyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * kafka controller
 *
 * @author cy
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaMyProducer producer;

    @GetMapping(value = "sendMsg")
    public String sendMsg(@RequestParam("message") String message){
        producer.send(message);
        return "OK";
    }

    @GetMapping(value = "sendTopicMsg")
    public String sendTopicMsg(@RequestParam("message") String message,String partition){
        producer.send("testTopic",partition,message);
        return "OK";
    }


}
