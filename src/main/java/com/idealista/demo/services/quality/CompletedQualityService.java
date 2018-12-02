package com.idealista.demo.services.quality;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.idealista.demo.model.Anuncio;

@Service
public class CompletedQualityService {
	
	public int quality(Anuncio anuncio) {
		if (completed(anuncio)) {
			return 40;
		}
		return 0;
	}

	private  boolean completed(Anuncio anuncio) {
		switch (anuncio.getTypology()) {
		case CHALET:
			return chaletIsCompleted(anuncio);
		case FLAT:
			return flatIsCompleted(anuncio);
		case GARAGE:
			return garageIsCompleted(anuncio);
		default:
			return false;
		}
	}

	private boolean chaletIsCompleted(Anuncio anuncio) {
		return !anuncio.getPictures().isEmpty() && !StringUtils.hasText(anuncio.getDescription())
				&& anuncio.getHouseSize() != null && anuncio.getGardenSize() != null;
	}

	private boolean flatIsCompleted(Anuncio anuncio) {
		return !anuncio.getPictures().isEmpty() && !StringUtils.hasText(anuncio.getDescription())
				&& anuncio.getHouseSize() != null;
	}

	private boolean garageIsCompleted(Anuncio anuncio) {
		return !anuncio.getPictures().isEmpty();
	}

}
