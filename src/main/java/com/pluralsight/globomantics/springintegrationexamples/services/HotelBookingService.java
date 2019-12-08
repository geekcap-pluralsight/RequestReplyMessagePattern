package com.pluralsight.globomantics.springintegrationexamples.services;

import org.springframework.messaging.Message;

public interface HotelBookingService {
    Message<Boolean> checkAvailability(Message<Integer> numberOfGuests);
}
