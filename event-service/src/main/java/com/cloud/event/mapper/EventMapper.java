package com.cloud.event.mapper;

import com.cloud.event.domain.Event;
import com.cloud.event.domain.User;
import com.cloud.event.dto.EventDTO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EventMapper {

    public Event buildEvent(User user, EventDTO eventDTO) {
       return new Event(eventDTO.getIdEvent(), user, eventDTO.getName(),
               eventDTO.getCategory(), eventDTO.getPlace(), eventDTO.getAddress(),
               eventDTO.getInitialDate(), eventDTO.getFinalDate(),
               eventDTO.getPresencial(), new Date());
    }

    public Event buildEventUpdate(Event event, EventDTO eventDTO) {
        event.setAddress(eventDTO.getAddress());
        event.setCategory(eventDTO.getCategory());
        event.setFinalDate(eventDTO.getFinalDate());
        event.setInitialDate(eventDTO.getInitialDate());
        event.setPlace(eventDTO.getPlace());
        event.setPresencial(eventDTO.getPresencial());
        event.setName(eventDTO.getName());
        return event;
    }
}
