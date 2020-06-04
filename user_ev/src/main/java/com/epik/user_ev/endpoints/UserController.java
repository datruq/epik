package com.epik.user_ev.endpoints;

import com.epik.user_ev.dto.UserDto;
import com.epik.user_ev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user, HttpServletRequest request) {
        if (userService.saveUser(user)){
            return new ResponseEntity<UserDto>(new UserDto(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId, HttpServletRequest request) {
        return new ResponseEntity<UserDto>(new UserDto(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> getAllUsers(HttpServletRequest request) {

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}