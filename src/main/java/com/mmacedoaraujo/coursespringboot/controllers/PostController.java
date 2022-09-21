package com.mmacedoaraujo.coursespringboot.controllers;

import com.mmacedoaraujo.coursespringboot.controllers.util.URL;
import com.mmacedoaraujo.coursespringboot.domain.Post;
import com.mmacedoaraujo.coursespringboot.services.PostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);

        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text, @RequestParam(value = "minDate", defaultValue = "") String minDate, @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
       text = URL.decodeParam(text);
       Date min = URL.convertDate(minDate, new Date(0));
       Date max = URL.convertDate(maxDate, new Date());
       List<Post> list = postService.fullSearch(text, min, max);
       return ResponseEntity.ok().body(list);
    }
}
