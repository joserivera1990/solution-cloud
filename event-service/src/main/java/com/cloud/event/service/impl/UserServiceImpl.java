package com.cloud.event.service.impl;

import com.cloud.event.domain.Event;
import com.cloud.event.domain.User;
import com.cloud.event.dto.EventDTO;
import com.cloud.event.dto.UserDTO;
import com.cloud.event.repository.EventsRepository;
import com.cloud.event.repository.UserRepository;
import com.cloud.event.service.UserService;
import io.vavr.control.Option;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public Option<UserDTO> findUserByEmailAndPassword(String email, String password) {
        User user =  repository.findUserByEmailAndPassword(email, password);
        return Option.of(user)
                .map(oneUser -> mapper.map(oneUser, UserDTO.class));
    }

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = mapper.map(userDTO, User.class);
        return  repository.save(user);
    }

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
}
