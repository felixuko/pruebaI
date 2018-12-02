package com.idealista.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.idealista.demo.model.Anuncio;
import com.idealista.demo.model.Foto;
import com.idealista.demo.model.Typology;
import com.idealista.demo.repositories.AnuncioRepository;
import com.idealista.demo.repositories.FotoRepository;

@Component
public class AnunciosBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AnuncioRepository anuncioRespository;
    private FotoRepository fotoRepository;

    public AnunciosBootstrap(AnuncioRepository anuncioRespository, FotoRepository fotoRepository) {
        this.anuncioRespository = anuncioRespository;
        this.fotoRepository = fotoRepository;
    }

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		anunciosData();
	}
	
	private void anunciosData(){
		
		//Anuncio1
		Anuncio anuncio1 = new Anuncio("Este piso es una ganga, compra, compra, COMPRA!!!!!", Typology.CHALET);
		anuncio1.setHouseSize(300);
		anuncio1.setId(1L);
		anuncioRespository.save(anuncio1);
		
		
		Anuncio anuncio2 = new Anuncio("Nuevo ático céntrico recién reformado. No deje pasar la oportunidad y adquiera este ático de lujo", Typology.FLAT);
		anuncio2.setId(2L);
		Foto foto4 = new Foto(4L, "http://www.idealista.com/pictures/4", "HD");
		
		//Anuncio2
		foto4.getAnuncios().add(anuncio2);
		fotoRepository.save(foto4);
		
		anuncio2.getPictures().add(foto4);
		anuncioRespository.save(anuncio2);
		
		//Anuncio3
		Anuncio anuncio3 = new Anuncio("", Typology.CHALET);
		anuncio3.setId(3L);
		anuncio3.setHouseSize(210);
		anuncio3.setGardenSize(25);
		
		Foto foto2 = new Foto(2L, "http://www.idealista.com/pictures/2", "HD");
		foto2.getAnuncios().add(anuncio3);
		
		fotoRepository.save(foto2);
		
		anuncio3.getPictures().add(foto2);		
		anuncioRespository.save(anuncio3);
		
		//Anuncio4
		Anuncio anuncio4 = new Anuncio("Ático céntrico muy luminoso y recién reformado, parece nuevo", Typology.FLAT);
		anuncio4.setId(4L);
		anuncio4.setHouseSize(130);
		
		Foto foto5 = new Foto(5L, "http://www.idealista.com/pictures/5", "SD");
		foto5.getAnuncios().add(anuncio4);
		
		fotoRepository.save(foto5);
		
		anuncio4.getPictures().add(foto5);
		anuncioRespository.save(anuncio4);
		
		//Anuncio5
		Anuncio anuncio5 = new Anuncio("Pisazo", Typology.FLAT);
		anuncio5.setId(5L);
		
		Foto foto3 = new Foto(3L, "http://www.idealista.com/pictures/3", "SD");
		foto3.getAnuncios().add(anuncio5);
		fotoRepository.save(foto3);
		
		anuncio5.getPictures().add(foto3);
		anuncio5.getPictures().add(foto4);
		anuncioRespository.save(anuncio5);
		
		foto4.getAnuncios().add(anuncio5);		
		fotoRepository.save(foto4);
		
		//Anuncio6
		Anuncio anuncio6 = new Anuncio("", Typology.GARAGE);
		anuncio6.setId(6L);
		
		Foto foto6 = new Foto(6L, "http://www.idealista.com/pictures/6", "SD");
		foto6.getAnuncios().add(anuncio6);
		fotoRepository.save(foto6);
		
		anuncio6.getPictures().add(foto6);
		anuncioRespository.save(anuncio6);
		
		Anuncio anuncio7 = new Anuncio("Garaje en el centro de Albacete", Typology.GARAGE);
		anuncio7.setId(7L);
		anuncioRespository.save(anuncio7);
		
		Anuncio anuncio8 = new Anuncio("Maravilloso chalet situado en als afueras de un pequeño pueblo rural. El entorno es espectacular, las vistas magníficas. ¡Cómprelo ahora!",
				Typology.CHALET);
		anuncio8.setId(8L);
		anuncio8.setHouseSize(150);
		anuncio8.setGardenSize(20);
		
		Foto foto1 = new Foto(1L, "http://www.idealista.com/pictures/1", "SD");
		foto1.getAnuncios().add(anuncio8);
		fotoRepository.save(foto1);
		Foto foto7 = new Foto(7L, "http://www.idealista.com/pictures/7", "SD");
		foto7.getAnuncios().add(anuncio8);
		fotoRepository.save(foto7);
		
		anuncio8.getPictures().add(foto1);
		anuncio8.getPictures().add(foto7);
		anuncioRespository.save(anuncio8);
		
	}
	
}
