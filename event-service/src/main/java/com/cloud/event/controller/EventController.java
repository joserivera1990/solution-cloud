package com.cloud.event.controller;

import com.cloud.event.dto.EventDTO;
import com.cloud.event.service.EventsService;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventsService eventsService;

    @RequestMapping(value = "/{eventId}", method = RequestMethod.GET)
    public ResponseEntity getAllEvents(@PathVariable String eventId){

        Option<List<EventDTO>> events = eventsService.getEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
