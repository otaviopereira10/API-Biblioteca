package com.projeto.biblioteca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String price;

	private String imageUrl;
	
	

	public Livro(Long id, String title, String price, String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	

	public String getTitle() {
		return title;
	}

	public Livro() {
		super();
	}



	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
