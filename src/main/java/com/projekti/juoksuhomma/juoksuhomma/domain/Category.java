package com.projekti.juoksuhomma.juoksuhomma.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference; 

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "category")
	@JsonBackReference
	private List<Juoksuhomma> juoksut;
	
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryid(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Juoksuhomma> getJuoksut(){
		return juoksut;
	}
	public void setJuoksut(List<Juoksuhomma> juoksut) {
		this.juoksut = juoksut;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name="+ name + "]";
	}
}
