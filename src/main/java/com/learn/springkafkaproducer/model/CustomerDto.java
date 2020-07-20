package com.learn.springkafkaproducer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CustomerDto {

    private String firstName;
    private String lastName;
    private Integer age;
}
