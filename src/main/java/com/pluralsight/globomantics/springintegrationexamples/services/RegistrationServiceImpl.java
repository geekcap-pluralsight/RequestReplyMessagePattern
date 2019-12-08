package com.pluralsight.globomantics.springintegrationexamples.services;

import com.pluralsight.globomantics.springintegrationexamples.config.HotelBookingGateway;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger logger = LogManager.getLogger(RegistrationService.class);

    @Autowired
    private HotelBookingGateway hotelBookingGateway;

    @Override
    public Boolean checkAvailability(Integer numberOfGuests) {
        logger.info("Checking hotel availability for {} guests", numberOfGuests);
        Message<Integer> message = MessageBuilder.withPayload(numberOfGuests).build();
        Message<Boolean> response = hotelBookingGateway.checkAvailability(message);

        logger.info("Hotel Booking Service returned: {}", response);
        return response.getPayload();
    }
}
