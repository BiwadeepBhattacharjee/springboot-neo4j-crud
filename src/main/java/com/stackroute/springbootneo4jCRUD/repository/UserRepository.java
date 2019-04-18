package com.stackroute.springbootneo4jCRUD.repository;

import com.stackroute.springbootneo4jCRUD.domain.Movie;
import com.stackroute.springbootneo4jCRUD.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User,Long> {
    @Query("MATCH (u:User)<-[l:likes]-(m-Movie) RETURN u,r,m")
    Iterable<User> getAllUsers();

    @Query("CREATE (u:User{id:({id}),name:({name}),age:({age})})")
    User saveUserDetails(Long id,String name,int age);

    @Query("CREATE (m:Movie{movieID:({movieID}),title:({title})})")
    Movie saveMovieDetails(Long movieID, String title);

//    @Query("MATCH (n) RETURN n")
//    Iterable<User> getAll();

    @Query("MATCH (n) DETACH DELETE n")
    void deleteAllNodesAndRelationship();

    @Query("MATCH (u:User) where u.name=({name1}) MATCH (u1:User) where u1.name=({name2}) CREATE (u)-[:friendof{type:({comment})}]->(u1)")
    void friendofRelation(String name1,String name2,String comment);

    @Query("MATCH (u:User) where u.name=({name}) MATCH (m:Movie) where m.title=({movie}) CREATE (u)-[:likes{type:({comment})}]->(m)")
    void likedRelatioship(String name,String movie,String comment);

    @Query("MATCH (u:User) where u.name=({name}) MATCH (u)-[friendof]->(r:User) MATCH (r)-[likes]->(x:Movie) RETURN x;")
    List<Movie> recomendedMovie(String name);

    @Query("LOAD CSV WITH HEADERS FROM 'file:///sample.csv' AS row with row where row.type='concept' CREATE (:Concept {id:row.identity, name: row.name, parentId:row.parentId, class: row.class, relation: row.parentRelation, context: row.context})")
    void loadCSVFile();
}
