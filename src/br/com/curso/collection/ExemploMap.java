package br.com.curso.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ExemploMap {

	public static void main(String[] args) {
		System.out.println("1 - Criar um dicionario com modelos de carros e seu consumo:");
		Map<String, Double> carPop = new HashMap<>() {
			private static final long serialVersionUID = 1L;
			{
				put("gol", 14.4);
				put("uno", 15.6);
				put("mobi", 16.1);
				put("hb20", 14.5);
				put("kwid", 15.6);
			}
		};
		System.out.println("\t" + carPop);

		System.out.println("2 - Substituir o consumo do gol por 15,2 km/l:");
		carPop.put("gol", 15.2);
		System.out.println("\t" + carPop);

		System.out.println("3 - Confira se o modelo esta no dicionario:");
		System.out.println("\tuno:    " + carPop.containsKey("uno"));
		System.out.println("\ttucson: " + carPop.containsKey("tucson"));

		System.out.println("4 - Exibir o consumo do uno:");
		System.out.println("\t" + carPop.get("uno"));

		System.out.println("5 - Exibir todos modelos:");
		System.out.println("\t" + carPop.keySet());

		System.out.println("6 - Exibir todos consumos:");
		System.out.println("\t" + carPop.values());

		System.out.println("7 - Exibir o modelo mais economico:");
		for (Map.Entry<String, Double> entry : carPop.entrySet()) {
			if (entry.getValue().equals(Collections.max(carPop.values())))
				System.out.println("\t" + entry.getKey() + " - " + entry.getValue());
		}

		System.out.println("8 - Exibir o modelo menos economico:");
		for (Map.Entry<String, Double> entry : carPop.entrySet()) {
			if (entry.getValue().equals(Collections.min(carPop.values())))
				System.out.println("\t" + entry.getKey() + " - " + entry.getValue());
		}

		System.out.println("9 - Exibir a soma dos consumos:");
		Double soma = 0d;
		for (Iterator<Double> i = carPop.values().iterator(); i.hasNext();) {
			soma += i.next();
		}
		System.out.println("\tSoma Consumo: " + soma);

		System.out.println("10 - Exibir a média dos consumos:");
		System.out.println("\tSoma Consumo: " + (soma / carPop.size()));

		System.out.println("11 - Remover os carros com consumo igual a 15,6 km/l:");
		for (Iterator<Double> i = carPop.values().iterator(); i.hasNext();) {
			if (i.next().equals(15.6))
				i.remove();
		}
		System.out.println("\t" + carPop);

		System.out.println("12 - Exibir na ordem de inserção:");
		Map<String, Double> carPopOrdem = new LinkedHashMap<>() {
			private static final long serialVersionUID = 1L;
			{
				put("gol", 14.4);
				put("uno", 15.6);
				put("mobi", 16.1);
				put("hb20", 14.5);
				put("kwid", 15.6);
			}
		};
		System.out.println("\t" + carPopOrdem);

		System.out.println("13 - Exibir ordenado pelo modelo:");
		Map<String, Double> carPopModelo = new TreeMap<>(carPopOrdem);
		System.out.println("\t" + carPopModelo);

		System.out.println("14 - Apague o dicionario:");
		carPop.clear();
		System.out.println("\tEsta vazio o dicionario: " + carPop.isEmpty());
	}

}
