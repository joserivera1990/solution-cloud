package com.cloud.event.service;

import com.cloud.event.domain.Event;
import com.cloud.event.dto.EventDTO;
import io.vavr.control.Option;

import java.util.List;

public interface EventsService {

    Option<List<EventDTO>> getEvents(Integer idUser);

    Option<EventDTO> getEventById(Integer idEvent);

    void removeByIdEvent(Integer idEvent);

    Event saveEvent(EventDTO eventDTO);

    Event updateEvent(EventDTO eventDTO);
}
