package com.idealista.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.idealista.demo.model.Anuncio;

public interface AnuncioRepository extends CrudRepository<Anuncio, Long> {

	@Query("SELECT a FROM Anuncio a WHERE a.rating > :rating ORDER BY a.rating DESC")
    public List<Anuncio> findByRatingGreaterThan(@Param("rating") Integer rating);
	
	@Query("SELECT a FROM Anuncio a WHERE a.rating < :rating")
    public List<Anuncio> findByRatingLowerThan(@Param("rating") Integer rating);
	
}
