package com.radahv.taskapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple health-check endpoint used to verify that the application is running.
 * <p>
 * Useful for local testing and deployment verification.
 */
@RestController
public class HealthController {

    @GetMapping("/health")
    public String health(){
        return "OK";
    }
}
