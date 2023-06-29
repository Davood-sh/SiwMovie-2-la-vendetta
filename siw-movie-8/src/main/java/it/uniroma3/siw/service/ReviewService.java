package it.uniroma3.siw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Movie;
import it.uniroma3.siw.model.Review;
import it.uniroma3.siw.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired ReviewRepository reviewRepository;

	public void save(Review review) {
		this.reviewRepository.save(review);
	}

	public void delete(Long id) {
		this.reviewRepository.deleteById(id);
	}

	public Review findById(Long id) {
		return this.reviewRepository.findById(id).get();
	}

	public List<Review> findByMovie(Movie movie){
		List<Review> result = new ArrayList<>();
		Iterable<Review> iterable = this.reviewRepository.findByMovie(movie);
		for(Review review : iterable)
			result.add(review);
		return result;
	}

}
