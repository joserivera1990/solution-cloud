package com.cloud.event.service.impl;

import com.cloud.event.domain.Event;
import com.cloud.event.domain.User;
import com.cloud.event.dto.EventDTO;
import com.cloud.event.mapper.EventMapper;
import com.cloud.event.repository.EventsRepository;
import com.cloud.event.repository.UserRepository;
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

    private final UserRepository userRepository;

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private EventMapper eventMapper;

    @Override
    public Option<List<EventDTO>> getEvents(Integer idUser) {
        User user = userRepository.findByIdUser(idUser);
        List<Event> listEvents =  repository.findByUserOrderByRegisterDateDesc(user);
        return Option.of(listEvents).map(t -> t.stream()
                .map(event -> mapper.map(event, EventDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public Option<EventDTO> getEventById(Integer idEvent) {
        Event event =  repository.findByIdEvent(idEvent);
        return Option.of(event)
                .map(oneEvent -> mapper.map(oneEvent, EventDTO.class));
    }

    @Override
    public Event saveEvent(EventDTO eventDTO) {
        User user = userRepository.findByIdUser(eventDTO.getIdUser());
        Event event = eventMapper.buildEvent(user, eventDTO);
        return  repository.save(event);
    }

    @Override
    public Event updateEvent(EventDTO eventDTO) {
        Event event = repository.findByIdEvent(eventDTO.getIdEvent());
        Event eventToUpdate = eventMapper.buildEventUpdate(event, eventDTO);
        return  repository.save(eventToUpdate);
    }

    @Override
    public void removeByIdEvent(Integer idEvent) {
        repository.removeByIdEvent(idEvent);
    }

    public EventsServiceImpl(EventsRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }
}
