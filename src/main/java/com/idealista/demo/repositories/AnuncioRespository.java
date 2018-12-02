package com.idealista.demo.repositories;

import com.idealista.demo.model.Anuncio;
import org.springframework.data.repository.CrudRepository;

public interface AnuncioRespository extends CrudRepository<Anuncio, Long> {

}
