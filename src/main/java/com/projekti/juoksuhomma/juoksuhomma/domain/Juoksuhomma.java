package com.projekti.juoksuhomma.juoksuhomma.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Juoksuhomma {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nimimerkki;
	private Double matka;
	private int kesto;
	private String pvm;
	private String lisatieto;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name ="categoryId")
	private Category category;
	
	public Juoksuhomma() {
		
		}


	public Juoksuhomma(String nimimerkki, Double matka, int kesto, String pvm, String lisatieto, Category category) {
		super();
		this.nimimerkki = nimimerkki;
		this.matka = matka;
		this.kesto = kesto;
		this.pvm = pvm;
		this.lisatieto = lisatieto;
		this.category = category;
	}
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNimimerkki() {
		return nimimerkki;
	}
	public void setNimimerkki(String nimimerkki) {
		this.nimimerkki = nimimerkki;
	}
	public Double getMatka() {
		return matka;
	}
	public void setMatka(Double matka) {
		this.matka = matka;
	}
	public int getKesto() {
		return kesto;
	}
	public void setKesto(int kesto) {
		this.kesto = kesto;
	}
	public String getPvm() {
		return pvm;
	}
	public void setPvm(String pvm) {
		this.pvm = pvm;
	}
	public String getLisatieto() {
		return lisatieto;
	}
	public void setLisatieto(String lisatieto) {
		this.lisatieto = lisatieto;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Juoksuhomma [id=" + id + ", nimimerkki=" + nimimerkki + ", matka=" + matka + ", kesto=" + kesto
				+ ", pvm=" + pvm + ", lisatieto=" + lisatieto + ", category=" + category + "]";
	}


	public void setCategory(String string) {
		
	}
	
	
	
	
}