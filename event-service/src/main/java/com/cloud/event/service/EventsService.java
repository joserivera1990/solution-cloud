package com.cloud.event.service;

import com.cloud.event.domain.Event;
import com.cloud.event.dto.EventDTO;
import com.cloud.event.service.impl.EventsServiceImpl;
import io.vavr.control.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventsService {

    Option<List<EventDTO>> getEvents();

    Option<EventDTO> getEventById(Integer idEvent);

    void removeByIdEvent(Integer idEvent);

    Event saveEvent(EventDTO eventDTO);
}
