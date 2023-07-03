package com.devdan.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devdan.workshopmongo.domain.Post;
import com.devdan.workshopmongo.repository.PostRepository;
import com.devdan.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("object not found"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
}
