package com.mmacedoaraujo.coursespringboot.repository;

import com.mmacedoaraujo.coursespringboot.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
