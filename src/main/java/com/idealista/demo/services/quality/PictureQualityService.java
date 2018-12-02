package com.idealista.demo.services.quality;

import org.springframework.stereotype.Service;

import com.idealista.demo.model.Anuncio;
import com.idealista.demo.model.Foto;

@Service
public class PictureQualityService {

	public int quality(Anuncio anuncio) {
		int rating = 0;
		if (anuncio.getPictures().isEmpty()) {
			rating -= 10;
		} else {
			rating += anuncio.getPictures().stream().mapToInt(this::pictureQualityRating).sum();
		}
		return rating;
	}

	private int pictureQualityRating(Foto foto) {
		return "HD".equals(foto.getQuality()) ? 20 : 10;
	}

}
