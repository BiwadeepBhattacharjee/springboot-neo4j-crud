package com.stackroute.springbootneo4jCRUD.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;
//import org.neo4j.ogm.annotation.Id;


@NodeEntity(label = "Movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@RelationshipEntity(type="likes")
public class Movie {
    @Id
    private Long id;
    private String title;
    private Long rating;

//    @StartNode
//    private User user;
//
//    @EndNode
//    private Movie movie;

}
