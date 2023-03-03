package br.com.curso.collection.ex;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class ExRandom {

	public static void main(String[] args) {
		Random rand = new Random();
		Map<Integer, Integer> Dados = new LinkedHashMap<>();

		for (int i = 0; i < 100; i++) {
			Dados.put(i, (rand.nextInt(10) + 1));
		}

		for (int i = 1; i <= 10; i++) {
			System.out.println("\t" + "Quantidade do valor (" + i + "): " + Collections.frequency(Dados.values(), i));
		}
	}

}
