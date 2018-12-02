package com.idealista.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idealista.demo.model.Anuncio;
import com.idealista.demo.repositories.AnuncioRepository;
import com.idealista.demo.services.RatingService;

@RestController
@RequestMapping(method = { RequestMethod.GET})
public class UserController {

	@Value("${puntuacion.minima}")
	private int puntuacionMinima;
	
	RatingService ratingService;
	AnuncioRepository anuncioRespository;
	
	public UserController(RatingService ratingService, AnuncioRepository anuncioRespository) {
		this.ratingService = ratingService;
		this.anuncioRespository = anuncioRespository;
	}
	
	@RequestMapping("/userList")
	public List<Anuncio> userList() {
		return anuncioRespository.findByRatingGreaterThan(puntuacionMinima - 1).stream()
				.collect(Collectors.toList());
	}
	
}
