package com.stackroute.springbootneo4jCRUD.controller;

import com.stackroute.springbootneo4jCRUD.domain.Movie;
import com.stackroute.springbootneo4jCRUD.domain.User;
import com.stackroute.springbootneo4jCRUD.service.UserService;
import com.stackroute.springbootneo4jCRUD.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/api/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl){
        this.userService=userServiceImpl;
    }

    /*Mapping of Saveplayer Details Method*/
    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        userService.saveUser(user);
        responseEntity = new ResponseEntity<String>("Succesfully add", HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/movie")
    public ResponseEntity<String> saveMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        userService.saveMovie(movie);
        responseEntity = new ResponseEntity<String>("Succesfully add", HttpStatus.CREATED);
        return responseEntity;
    }
//
//    @GetMapping("/users")
//    public ResponseEntity<Iterable<User>> getPlayers() {
//        Iterable<User> allUsers = userService.getAllUsers();
//        return new ResponseEntity<Iterasudo docker run --publish=7474:7474 --publish=7687:7687 -v $HOME/neo4j/data:/data -v $HOME/neo4j/import:/import  neo4j:3.0ble<User>>(allUsers, HttpStatus.OK);
//    }

    @PostMapping("/rating")
    public ResponseEntity<String> saverating(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        userService.saveMovie(movie);
        responseEntity = new ResponseEntity<String>("Succesfully add", HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/friendof/{user1}/{user2}/{comment}")
    public ResponseEntity<String> saveFriendof(@PathVariable String user1,@PathVariable String user2,@PathVariable String comment) {
        ResponseEntity responseEntity;
        userService.friendofRelation(user1,user2,comment);
        responseEntity = new ResponseEntity<String>("Succesfully add", HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/liked/{user}/{movie}/{comment}")
    public ResponseEntity<String> saveLikeMovie(@PathVariable String user,@PathVariable String movie,@PathVariable String comment) {
        ResponseEntity responseEntity;
        userService.likeRelation(user,movie,comment);
        responseEntity = new ResponseEntity<String>("Succesfully add", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAll() {
        Iterable<User> allUsers = userService.getAll();
        return new ResponseEntity<Iterable<User>>(allUsers, HttpStatus.OK);
    }


    @DeleteMapping("/del")
    public void deleteData() {
        userService.deleteData();
    }

    @GetMapping("/recomandation/{name}")
    public ResponseEntity<Iterable<Movie>> getRecomandation(@PathVariable String name) {
        Iterable<Movie> allRecomandation = userService.recomendMovie(name);
        return new ResponseEntity<Iterable<Movie>>(allRecomandation, HttpStatus.OK);
    }


}
