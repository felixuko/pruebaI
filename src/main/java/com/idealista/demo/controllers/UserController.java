package com.idealista.demo.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idealista.demo.model.Anuncio;
import com.idealista.demo.repositories.AnuncioRespository;
import com.idealista.demo.services.RatingService;

@RestController
@RequestMapping(method = { RequestMethod.GET})
public class UserController {

	RatingService ratingService;
	AnuncioRespository anuncioRespository;
	
	public UserController(RatingService ratingService, AnuncioRespository anuncioRespository) {
		this.ratingService = ratingService;
		this.anuncioRespository = anuncioRespository;
	}
	
	@RequestMapping("/userList")
	public List<Anuncio> userList() {
		return StreamSupport.stream(anuncioRespository.findAll().spliterator(), false)
				.filter(ar -> ratingService.rating(ar) > 40)
				.sorted(Comparator.comparing(ratingService::rating).reversed())
				.collect(Collectors.toList());
	}
	
}
