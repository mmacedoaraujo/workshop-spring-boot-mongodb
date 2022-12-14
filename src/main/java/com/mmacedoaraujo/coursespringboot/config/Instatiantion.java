package com.mmacedoaraujo.coursespringboot.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import com.mmacedoaraujo.coursespringboot.domain.Post;
import com.mmacedoaraujo.coursespringboot.dto.AuthorDTO;
import com.mmacedoaraujo.coursespringboot.dto.CommentDTO;
import com.mmacedoaraujo.coursespringboot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mmacedoaraujo.coursespringboot.domain.User;
import com.mmacedoaraujo.coursespringboot.repository.UserRepository;

@Configuration
public class Instatiantion implements ApplicationRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;


	@Override
	public void run(ApplicationArguments args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("22/03/2018)"), "Partiu viagem", "Partiu viagem!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Férias", "Partiu férias", new AuthorDTO(maria));

		CommentDTO comment = new CommentDTO("Boa viagem mano",sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("Aproveite",sdf.parse("21/03/2018"), new AuthorDTO(bob));
		CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia",sdf.parse("21/03/2018"), new AuthorDTO(alex));

		post1.getComments().addAll(Arrays.asList(comment, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));

		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
