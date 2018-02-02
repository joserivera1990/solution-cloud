package com.cloud.event.service.impl;

import com.cloud.event.domain.User;
import com.cloud.event.dto.UserDTO;
import com.cloud.event.repository.UserRepository;
import com.cloud.event.service.UserService;
import io.vavr.control.Option;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public boolean saveUser(UserDTO userDTO) {
        User user = buildUser(userDTO);
        User userExist = repository.findByEmail(userDTO.getEmail());
        if (userExist == null) {
            repository.save(user);
            return true;
        } else {
            return false;
        }
    }

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    private User buildUser(UserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword(), new Date());

    }

}
