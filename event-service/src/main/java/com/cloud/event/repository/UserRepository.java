package com.cloud.event.repository;

import com.cloud.event.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User,String> {

    User findUserByEmailAndPassword(String email, String password);

    User save(User user);

    User findByIdUser(Integer idUser);

    User findByEmail(String email);
}
