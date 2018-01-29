package com.cloud.event.repository;

import com.cloud.event.domain.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EventsRepository extends JpaRepository<Event,String> {

    List<Event> findAll();

    Event findByIdEvent(String idEvent);

    Event removeByIdEvent(String idEvent);

    Event save(Event event);
}
