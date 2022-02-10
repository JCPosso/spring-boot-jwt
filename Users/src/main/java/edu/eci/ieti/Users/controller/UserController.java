package edu.eci.ieti.Users.controller;

import edu.eci.ieti.Users.data.User;
import edu.eci.ieti.Users.dto.UserDto;
import edu.eci.ieti.Users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService ) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto ) {
        String id = "1";
        List<User> users= userService.getAll();
        if (users.size()>0){
             id = String.valueOf(userService.getAll().size()+1);
        }
        String today = DateTimeFormatter.ofPattern("YYYY-MM-DD").format(LocalDate.now());
        User user = new User(id,userDto,today);
        return ResponseEntity.status(HttpStatus.OK).body(userService.create(user));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userDto,id));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        try {
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((false));
        }
    }

    @GetMapping( "/findUsersWithNameOrLastNameLike/{queryText}" )
    public ResponseEntity<List<User>> findUsersWithNameOrLastNameLike( @PathVariable String queryText ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUsersWithNameOrLastNameLike(queryText));
    }

    @GetMapping( "/findUsersCreatedAfter/{startDate}" )
    public ResponseEntity<List<User>> findUsersCreatedAfter( @PathVariable Date startDate ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUsersCreatedAfter(startDate));
    }
}