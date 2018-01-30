package com.cloud.event.controller;

import com.cloud.event.domain.User;
import com.cloud.event.dto.UserDTO;
import com.cloud.event.service.UserService;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/email/{email}/password/{password}", method = RequestMethod.GET)
    public ResponseEntity findUserByEmailAndPassword(@PathVariable String email, @PathVariable String password){

        Option<UserDTO> user = userService.findUserByEmailAndPassword(email, password);

        if(user.isDefined()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity saveEvent(@RequestBody UserDTO userDTO){
        User user = userService.saveUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
