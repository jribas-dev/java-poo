package br.com.curso.oo;

public class Carro {

	String cor;
	String modelo;
	int capacidadeTanque;

	public Carro() {
	}

	public Carro(String cor, String modelo, int capacidadeTanque) {
		this.cor = cor;
		this.modelo = modelo;
		this.capacidadeTanque = capacidadeTanque;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(int capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public double totalValorTanuqe(double valorCombustivel) {
		return capacidadeTanque * valorCombustivel;
	}

	@Override
	public String toString() {
		return "Carro \n{\n\tcor: " + cor + ",\n\tmodelo: " + modelo + ",\n\tcapacidadeTanque: " + capacidadeTanque
				+ "\n}";
	}

}
