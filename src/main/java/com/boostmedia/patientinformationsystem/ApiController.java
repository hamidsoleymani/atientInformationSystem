package com.boostmedia.patientinformationsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/status")
    public String status() {
        return "API is up and runningn!" + LocalDateTime.now();
    }
}
