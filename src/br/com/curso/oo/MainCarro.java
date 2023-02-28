package br.com.curso.oo;

public class MainCarro {

	public static void main(String[] args) {
		Carro carro1 = new Carro("prata", "Fusion SEL 2.5", 51);
		System.out.println(carro1);
		System.out.println("Custo encher tanque: " + carro1.totalValorTanuqe(5.29));
		
		Carro carro2 = new Carro("preto", "Land Rover Discovery", 66);
		System.out.println("\n" + carro2);
		System.out.println("Custo encher tanque: " + carro2.totalValorTanuqe(5.29));
	}

}
