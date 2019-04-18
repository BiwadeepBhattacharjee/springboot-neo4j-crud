package com.stackroute.springbootneo4jCRUD.service;

import com.stackroute.springbootneo4jCRUD.domain.Movie;
import com.stackroute.springbootneo4jCRUD.domain.User;
import com.stackroute.springbootneo4jCRUD.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepositry){
        this.userRepository=userRepositry;
    }

    @Override
    public User saveUser(User user)  {
        User saveUser = userRepository.saveUserDetails(user.getId(),user.getName(),user.getAge());
        return saveUser;
    }
    
    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        Movie saveMovie = userRepository.saveMovieDetails(movie.getId(),movie.getTitle());
        return saveMovie;
    }

    @Override
    public Iterable<User> getAll() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    /*
        This method deletes all the nodes and its relationships from neo4j database
     */
    @Override
    public void deleteData() {
        userRepository.deleteAllNodesAndRelationship();
    }

    @Override
    public void friendofRelation(String name1, String name2,String comment) {
        userRepository.friendofRelation(name1,name2,comment);
    }

    @Override
    public void likeRelation(String user, String movie, String comment) {
        userRepository.likedRelatioship(user,movie,comment);
    }

    @Override
    public List<Movie> recomendMovie(String name) {
        return userRepository.recomendedMovie(name);
    }

}
