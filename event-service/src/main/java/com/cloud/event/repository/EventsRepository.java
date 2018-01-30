package com.cloud.event.repository;

import com.cloud.event.domain.Event;

import com.cloud.event.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface EventsRepository extends JpaRepository<Event,String> {

   List<Event> findByUserOrderByRegisterDateDesc(User user);

    Event findByIdEvent(Integer idEvent);

    @Transactional
    void removeByIdEvent(Integer idEvent);

    Event save(Event event);

}
