package com.pluralsight.globomantics.springintegrationexamples;

import com.pluralsight.globomantics.springintegrationexamples.services.RegistrationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RequestReplyMessagePatternApplication implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(RequestReplyMessagePatternApplication.class);

    @Autowired
    private RegistrationService registrationService;

    @Override
    public void run(String... args) throws Exception {
        Boolean available = registrationService.checkAvailability(4);
        logger.info("Hotel availability for 4 guests: {}", available);
    }

    public static void main(String[] args) {
        SpringApplication.run(RequestReplyMessagePatternApplication.class, args);
    }
}
