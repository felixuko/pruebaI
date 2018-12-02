package com.idealista.demo.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.idealista.demo.listeners.AnuncioEntityListener;

@Entity
@EntityListeners({AnuncioEntityListener.class})
@JsonInclude(Include.NON_NULL)
public class Anuncio {
	
	@Id
	private Long id;
	private String description;
	@Enumerated(EnumType.STRING)
	private Typology typology;
	private Integer houseSize;
	private Integer gardenSize;
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	private Integer rating;

	@ManyToMany(mappedBy = "anuncios")
	private Set<Foto> pictures = new HashSet<>();

	public Anuncio() {

	}

	public Anuncio(String description, Typology typology) {
		this.description = description;
		this.typology = typology;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Typology getTypology() {
		return typology;
	}

	public void setTypology(Typology typology) {
		this.typology = typology;
	}

	public Integer getHouseSize() {
		return houseSize;
	}

	public void setHouseSize(Integer houseSize) {
		this.houseSize = houseSize;
	}

	public Integer getGardenSize() {
		return gardenSize;
	}

	public void setGardenSize(Integer gardenSize) {
		this.gardenSize = gardenSize;
	}

	public Set<Foto> getPictures() {
		return pictures;
	}

	public void setPictures(Set<Foto> pictures) {
		this.pictures = pictures;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Anuncio [id=" + id + ", description=" + description + ", typology=" + typology + ", houseSize="
				+ houseSize + ", gardenSize=" + gardenSize + ", lastUpdated=" + lastUpdated + ", rating=" + rating
				+ ", pictures=" + pictures + "]";
	}

}
