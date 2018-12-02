package com.idealista.demo.services;

import org.springframework.stereotype.Service;

import com.idealista.demo.model.Anuncio;
import com.idealista.demo.services.quality.CompletedQualityService;
import com.idealista.demo.services.quality.DescriptionQualityService;
import com.idealista.demo.services.quality.PictureQualityService;

@Service
public class RatingService {
	
	CompletedQualityService completedQualityService;
	DescriptionQualityService descriptionQualityService;
	PictureQualityService pictureQualityService;
	
	public RatingService (CompletedQualityService completedQualityService,
			DescriptionQualityService descriptionQualityService,
			PictureQualityService pictureQualityService){
		this.completedQualityService = completedQualityService;
		this.descriptionQualityService = descriptionQualityService;
		this.pictureQualityService = pictureQualityService;
	}
	
	public int rating(Anuncio anuncio) {
		int rating = pictureQualityService.quality(anuncio);
		rating += descriptionQualityService.quality(anuncio);
		rating += completedQualityService.quality(anuncio);
		return rating;
	}
	
}
