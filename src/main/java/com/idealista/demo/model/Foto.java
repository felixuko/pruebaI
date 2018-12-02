package com.idealista.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
public class Foto {

	@Id
	private Long id;
	private String url;
	private String quality;

	@JsonIgnore
	@ManyToMany(targetEntity=Anuncio.class,
	    cascade = { 
	        CascadeType.ALL
	    }
	)
	@JoinTable(name = "anuncio_foto",
	    joinColumns = @JoinColumn(name = "foto_id"),
	    inverseJoinColumns = @JoinColumn(name = "anuncio_id")
	)
	private Set<Anuncio> anuncios = new HashSet<>();

	public Foto() {
	}
	
	
	public Foto(Long id, String url, String quality) {
		this.id = id;
		this.url = url;
		this.quality = quality;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	public Set<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(Set<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

}
