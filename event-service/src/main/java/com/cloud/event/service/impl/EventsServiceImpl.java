package com.cloud.event.service.impl;

import com.cloud.event.domain.Event;
import com.cloud.event.dto.EventDTO;
import com.cloud.event.repository.EventsRepository;
import com.cloud.event.service.EventsService;
import io.vavr.control.Option;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventsServiceImpl implements EventsService {

    private final EventsRepository repository;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public Option<List<EventDTO>> getEvents() {
        List<Event> listEvents =  repository.findAll();
        List<EventDTO> listEventDTO = new ArrayList<>();

        return Option.of(listEvents).map(t -> t.stream()
                .map(event -> mapper.map(event, EventDTO.class))
                .collect(Collectors.toList()));

    }

    public EventsServiceImpl(EventsRepository repository) {
        this.repository = repository;
    }
}
