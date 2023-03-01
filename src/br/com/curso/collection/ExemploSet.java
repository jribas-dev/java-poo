package br.com.curso.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet {

	public static void main(String[] args) {
		Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
		System.out.println(notas+"\n");
		
		System.out.println("01 - Confira se a nota 5.0 esta no conjunto");
		System.out.println("\t" + notas.contains(5d));
		
		System.out.println("02 - Exiba a menor nota");
		System.out.println("\t" + Collections.min(notas));

		System.out.println("03 - Exiba a maior nota");
		System.out.println("\t" + Collections.max(notas));

		System.out.println("04 - Exiba a soma das nota");
		Double soma = 0d;
		Iterator<Double> iterator = notas.iterator();
		while (iterator.hasNext())
			soma += iterator.next();
		System.out.println("\t" + soma);
		
		System.out.println("05 - Exiba a média das nota");
		System.out.println("\t" + (soma / notas.size()));
		
		System.out.println("06 - Remova a nota 0");
		notas.remove(0d);
		System.out.println("\t" + notas);
		
		System.out.println("07 - Remova as notas menores que 7");
		iterator = notas.iterator();
		while (iterator.hasNext())
			if (iterator.next() < 7d) iterator.remove();
		System.out.println("\t" + notas);
		
		System.out.println("08 - Exibir na ordem que foram informadas");
		Set<Double> notasL = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
		System.out.println("\t" + notasL);

		System.out.println("08 - Exibir na ordem crescente");
		Set<Double> notasT = new TreeSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
		System.out.println("\t" + notasT);
		
		System.out.println("08 - Apagar o conjunto");
		notas.clear();
		System.out.println("\tEsta vazio: " + notas.isEmpty());
		
	}

}
