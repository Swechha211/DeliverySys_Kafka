package com.delivery.delivery_system.controller;

import com.delivery.delivery_system.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {

        for (int i = 1; i <= 5; i++) {
            String value = "(" + Math.round(Math.random() * 100) + "," + Math.round(Math.random() * 100) + ")";
            this.kafkaService.updateLocation(value);
        }
            return new ResponseEntity<>(Map.of("message", "location produced"), HttpStatus.OK);
        }

}
