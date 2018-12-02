package com.idealista.demo.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

import com.idealista.demo.model.Anuncio;
import com.idealista.demo.services.RatingService;

@Component
public class AnuncioEntityListener {

	RatingService ratingService;
		
	public AnuncioEntityListener(RatingService ratingService) {
		this.ratingService = ratingService;
	}

	@PreUpdate
	@PrePersist
	public void preUpdate(Anuncio anuncio) {
		anuncio.setRating(ratingService.rating(anuncio));
	}
	
}
