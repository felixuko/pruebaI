package com.idealista.demo.services.quality;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.idealista.demo.model.Anuncio;

@Service
public class DescriptionQualityService {

	private static final List<String> GOOD_KEYWORDS = Arrays.asList("Luminoso", "Nuevo", "Céntrico", "Reformado", "Ático");
	
	public int quality(Anuncio anuncio) {
		int rating = 0;
		if (validDescription(anuncio.getDescription())) {
			rating += 5;
			rating += typologyDescriptionQuality(anuncio);
			rating += descriptionGoodKeywords(anuncio.getDescription());
		}
		return rating;
	}
	
	private int typologyDescriptionQuality(Anuncio anuncio) {
		switch (anuncio.getTypology()) {
			case FLAT:
				return flatDescriptionQuality(anuncio.getDescription());
			case CHALET:
				return chaletDescriptionQuality(anuncio.getDescription());
			case GARAGE:
				return 0;
			default:
				return 0;
		}
	}
	
	private int flatDescriptionQuality(String description) {
		if (description.length() >= 50) {
			return 30;
		} else if (description.length() >= 20) {
			return 10;
		}
		return 0;
	}
	
	private int chaletDescriptionQuality(String description) {
		if (description.length() >= 50) {
			return 20;
		}
		return 0;
	}
	
	private long descriptionGoodKeywords(String description) {
		String descriptionLowerCase = description.toLowerCase();
		return GOOD_KEYWORDS.stream()
				.map(String::toLowerCase)
				.filter(descriptionLowerCase::contains)
				.count() * 5;
	}
	
	private boolean validDescription(String description) {
		return !StringUtils.hasText(description);
	}

}
