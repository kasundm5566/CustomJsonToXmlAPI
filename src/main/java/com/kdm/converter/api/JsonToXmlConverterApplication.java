package com.kdm.converter.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.kdm.converter.service", "com.kdm.converter.domain.request"})
public class JsonToXmlConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonToXmlConverterApplication.class, args);
    }

}
