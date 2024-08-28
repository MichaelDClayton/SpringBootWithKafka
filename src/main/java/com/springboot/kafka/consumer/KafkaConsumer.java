package com.springboot.kafka.consumer;

import com.springboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "demotopic", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info("JSON Message received: {}", user.toString());
    }
}
