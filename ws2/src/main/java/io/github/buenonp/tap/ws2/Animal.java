package io.github.buenonp.tap.ws2;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Animal implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id
	private int id;
	private String nome;
	private String especie;
	
	public Animal() {
	}


	public Animal(int id, String nome, String especie) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	@Override
	public String toString() {
		return "Animal [id=" + id + ", nome=" + nome + ", especie=" + especie + "]";
	}

}
