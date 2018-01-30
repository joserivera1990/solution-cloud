package com.cloud.event.service;

import com.cloud.event.domain.User;
import com.cloud.event.dto.UserDTO;
import io.vavr.control.Option;

public interface UserService {

    User saveUser(UserDTO userDTO);

    Option<UserDTO> findUserByEmailAndPassword(String email, String password);
}
