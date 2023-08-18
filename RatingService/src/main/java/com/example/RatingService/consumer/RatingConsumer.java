package com.example.RatingService.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RatingConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RatingConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void messageListener(){

        LOGGER.info("Message consumed");

    }

}
