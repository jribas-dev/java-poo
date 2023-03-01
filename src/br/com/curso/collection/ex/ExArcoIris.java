package br.com.curso.collection.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ExArcoIris {

	public static void main(String[] args) {
		Set<String> arco = new LinkedHashSet<>(
				Arrays.asList("vermelho", "laranja", "amarelo", "verde", "azul", "azul-escuro", "violeta"));

		System.out.println("A - Imprimir cores uma abaixo da outra:");
		for (Iterator<String> iterator = arco.iterator(); iterator.hasNext();) {
			System.out.println("\t" + iterator.next());
		}

		System.out.println("B - Quantidade de cores que o arco iris tem:");
		System.out.println("\t" + arco.size());

		System.out.println("C - Exibir as cores em ordem alfabética:");
		Set<String> arcoOrdem = new TreeSet<>(arco);
		for (Iterator<String> iterator = arcoOrdem.iterator(); iterator.hasNext();) {
			System.out.println("\t" + iterator.next());
		}

		System.out.println("D - Exibir as cores na ordem inversa:");
		List<String> arcoReverso = new ArrayList<>(arco);
		Collections.reverse(arcoReverso);
		for (Iterator<String> iterator = arcoReverso.iterator(); iterator.hasNext();) {
			System.out.println("\t" + iterator.next());
		}

		System.out.println("E - Exibir as cores que iniciam com V:");
		for (Iterator<String> iterator = arco.iterator(); iterator.hasNext();) {
			String c = iterator.next();
			if (c.startsWith("v"))
				System.out.println("\t" + c);
		}

		System.out.println("F - Remova todas as cores que não começam com V:");
		for (Iterator<String> iterator = arco.iterator(); iterator.hasNext();) {
			String c = iterator.next();
			if (!c.startsWith("v"))
				iterator.remove();
		}
		System.out.println("\t" + arco);

		System.out.println("G - Limpe o conjunto:");
		arco.clear();
		System.out.println("\tArco Iris esta vazio: " + arco.isEmpty());

	}

}
