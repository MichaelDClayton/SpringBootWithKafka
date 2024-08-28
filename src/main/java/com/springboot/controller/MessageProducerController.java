package com.springboot.controller;

import com.springboot.kafka.producer.KafkaProducer;
import com.springboot.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageProducerController {

    private final KafkaProducer kafkaProducer;

    public MessageProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.send("demotopic", user);
        return ResponseEntity.ok("JSON Message sent successfully");
    }
}
