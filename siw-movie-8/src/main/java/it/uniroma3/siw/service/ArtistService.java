package it.uniroma3.siw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Artist;
import it.uniroma3.siw.model.Movie;
import it.uniroma3.siw.repository.ArtistRepository;
import it.uniroma3.siw.repository.MovieRepository;

@Service
public class ArtistService {
	
	@Autowired
	protected ArtistRepository artistRepository;
	
	@Autowired
	protected MovieRepository movieRepository;
	
	

	public Artist findById(Long directorId) {
		return this.artistRepository.findById(directorId).get();
	}

	public List<Artist> findAll() {
		List<Artist> result = new ArrayList<>();
		Iterable<Artist> iterable = this.artistRepository.findAll();
		for(Artist artist : iterable)
			result.add(artist);
		return result;
	}

	public List<Artist> findActorsNotInMovie(Long movieId) {
		List<Artist> result = new ArrayList<>();
		Iterable<Artist> iterable = this.artistRepository.findActorsNotInMovie(movieId);
		for(Artist artist : iterable)
			result.add(artist);
		return null;
	}

	@Transactional
	public void save(Artist artist) {
		this.artistRepository.save(artist);		
	}

	public boolean existsByNameAndSurname(String name, String surname) {		
		return this.artistRepository.existsByNameAndSurname(name, surname);
	}



}
