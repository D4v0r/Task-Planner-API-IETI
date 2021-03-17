package edu.eci.ieti.taskPlanerAPI.controllers;

import edu.eci.ieti.taskPlanerAPI.model.User;
import edu.eci.ieti.taskPlanerAPI.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("taskPlannerAPI/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){

        try {
            return  new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id){
        try {
            return  new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        try {
            return  new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
        } catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try {
            return  new ResponseEntity<>(service.update(user), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        try {
            service.remove(id);
            return  new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }
}
