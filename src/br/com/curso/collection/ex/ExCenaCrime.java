package br.com.curso.collection.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExCenaCrime {

	public static void main(String[] args) {
		List<String> perguntas = new ArrayList<>(
				Arrays.asList(
						"Telefonou para a vítima?", 
						"Esteve no local do crime?",
						"Mora perto da vítima?", 
						"Devia para a vítima?", 
						"Já trabalhou com a vítima?")
				);
		Scanner scan = new Scanner(System.in);
		int respostas = 0;

		for (int i = 0; i < perguntas.size(); i++) {
			System.out.println((i + 1) + " - " + perguntas.get(i) + " S/N");
			if (scan.next().compareToIgnoreCase("S") == 0)
				respostas++;
		}

		desvendarCrime(respostas);
		scan.close();
	}

	private static void desvendarCrime(int r) {
		switch (r) {
		case 1:
			System.out.println("Inocente");
			break;
		case 2:
			System.out.println("Suspeita");
			break;
		case 3:
		case 4:
			System.out.println("Cúmplice");
			break;
		case 5:
			System.out.println("Assassino");
			break;
		}
	}

}
