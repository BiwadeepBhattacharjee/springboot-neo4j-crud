package com.stackroute.springbootneo4jCRUD.service;

import com.stackroute.springbootneo4jCRUD.domain.Movie;
import com.stackroute.springbootneo4jCRUD.domain.User;
import org.springframework.stereotype.Service;

import java.rmi.MarshalledObject;
import java.util.List;

@Service
public interface UserService {
    public User saveUser(User User);
    public Iterable<User> getAllUsers();
    public Movie saveMovie(Movie movie);
    Iterable<User> getAll();



    void deleteData();
    void friendofRelation(String name1,String name2,String comment);

    void likeRelation(String user,String movie,String comment);

    List<Movie> recomendMovie(String name);
}
