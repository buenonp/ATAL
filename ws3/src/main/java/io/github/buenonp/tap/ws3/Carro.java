package io.github.buenonp.tap.ws3;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id
	private int id;
	private String placa;
	private String modelo;
	
	public Carro() {
	}

	public Carro(int id, String placa, String modelo) {
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", placa=" + placa + ", modelo=" + modelo + "]";
	}

}
