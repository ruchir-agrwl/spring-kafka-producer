package com.learn.springkafkaproducer.web;

import com.learn.springkafkaproducer.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    private KafkaTemplate kafkaTemplate;

    @Autowired
    public KafkaProducerController(KafkaTemplate<String,CustomerDto> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity publishkafkaData(@RequestBody CustomerDto customerDto){
        kafkaTemplate.send("myTopic", customerDto);
        return new ResponseEntity(customerDto,HttpStatus.CREATED);
    }
}
