package com.stackroute.springbootneo4jCRUD.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@RelationshipEntity(type = "friendof")
public class User {
    @Id
    private Long id;
    private String name;
    private int age;

    @Relationship(type = "likes")
    private List<Movie> movies;

    @Relationship(type = "friendof")
    private List<User> users;

//    @StartNode
//    private User user;
//
//    @EndNode
//    private User user1;


}
