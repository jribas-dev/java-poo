package br.com.curso.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExemploLista {

	public static void main(String[] args) {
		System.out.println("01- Crie uma lista e adicione 7 notas:");	

		List<Double> notas = new ArrayList<>();
		notas.add(7.0);
		notas.add(8.5);
		notas.add(9.3);
		notas.add(5.0);
		notas.add(7.0);
		notas.add(0.0);
		notas.add(3.6);
		System.out.println("\t" + notas);	

		System.out.println("02- Exiba a posição da nota 5.0:");	
		System.out.println("\t" + notas.indexOf(5d));	

		System.out.println("03- Adicione na lista a nota 8.0 na posição 4:");
		notas.add(4, 8d);
		System.out.println("\t" + notas);	

		System.out.println("04- Substitua a nota 5.0 pela nota 6.0:");
		notas.set(notas.indexOf(5d), 6d);
		System.out.println("\t" + notas);	

		System.out.println("05- Confira se a nota 5.0 esta na lista:");
		System.out.println("\t" + notas.contains(5d));
		
		System.out.println("06- Exiba a terceira nota da lista:");
		System.out.println("\t" + notas.get(2));
		
		System.out.println("07- Exiba a menor nota:");
		System.out.println("\t" + Collections.min(notas));

		System.out.println("08- Exiba a maior nota:");
		System.out.println("\t" + Collections.max(notas));

		System.out.println("09- Exiba a soma das notas:");

		Double soma = 0d;
		Iterator<Double> iterator = notas.iterator();
		while (iterator.hasNext()) 
			soma += iterator.next();
		
		System.out.println("\t" + soma);
		
		System.out.println("10- Exiba a média das notas:");
		System.out.println("\t" + (soma / notas.size()));
		
		System.out.println("11- Remova a nota 0:");
		notas.remove(0d);
		System.out.println("\t" + notas);	
		
		System.out.println("12- Remova a nota da posição 0:");
		notas.remove(0);
		System.out.println("\t" + notas);	
		
		System.out.println("13- Remova as notas menores que 7.0:");
		iterator = notas.iterator();
		while (iterator.hasNext()) 
			if (iterator.next() < 7d) iterator.remove();
		System.out.println("\t" + notas);	

		System.out.println("14- Apague toda lista:");
		notas.clear();
		System.out.println("\t" + "esta vazia: " + notas.isEmpty());	

	}

}
