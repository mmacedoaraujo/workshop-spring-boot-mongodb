package com.mmacedoaraujo.coursespringboot.services;

import com.mmacedoaraujo.coursespringboot.domain.Post;
import com.mmacedoaraujo.coursespringboot.repository.PostRepository;
import com.mmacedoaraujo.coursespringboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById (String id) {
        Optional<Post> post = postRepository.findById(id);

        return post.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
