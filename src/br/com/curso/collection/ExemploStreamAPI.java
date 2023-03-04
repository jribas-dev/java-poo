package br.com.curso.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ExemploStreamAPI {

	   public static void main(String[] args) {
	        List<String> numerosAleatorios =
	                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

	        System.out.println("01 - Imprima todos os elementos dessa lista de String:");
	        System.out.print("\t");
	        numerosAleatorios.forEach(s -> System.out.print(s + ", "));
	        System.out.print("\n");

	        System.out.println("02 - Pegue os 5 primeiros números e coloque dentro de um Set:");
	        Set<String> numerosAleatorios5Primeiros = numerosAleatorios.stream()
	                .limit(5)
	                .collect(Collectors.toSet());
	        System.out.println("\t" + numerosAleatorios5Primeiros);

	        System.out.println("03 - Transforme esta lista de String em uma lista de números inteiros.");
	        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
	                .map(Integer::parseInt)
	                .collect(Collectors.toList());
	        System.out.println("\t" + numerosAleatoriosInteger);

	        System.out.println("04 - Pegue os números pares e maiores que 2 e coloque em uma lista:");
	        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
	                .map(Integer::parseInt)
	                .filter(i -> (i % 2 == 0 && i > 2))
	                .collect(Collectors.toList());
	        System.out.println("\t" + listParesMaioresQue2);

	        System.out.println("05 - Mostre a média dos números: ");
	        System.out.print("\t");
	        numerosAleatorios.stream()
	                .mapToInt(Integer::parseInt)
	                .average()
	                .ifPresent(System.out::println);

	        System.out.println("06 - Remova os valores ímpares: ");
	        numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
	        System.out.println("\t" + numerosAleatoriosInteger);

	        System.out.println("07 - Ignore os 3 primeiros elementos da lista e imprima o restante:");
	        numerosAleatoriosInteger.stream()
	                .skip(3)
	                .forEach(i -> System.out.println("\t" + i));

	        System.out.println("08 - Retirando os números repetidos da lista, quantos números ficam? ");
	        long countNumerosUnicos = numerosAleatoriosInteger.stream()
	                .distinct()
	                .count();
	        System.out.println("\t" + countNumerosUnicos);

	        System.out.println("09 - Mostre o menor valor da lista: ");
	        numerosAleatoriosInteger.stream()
	                .mapToInt(Integer::intValue)
	                .min()
	                .ifPresent(i -> System.out.println("\t" + i));

	        System.out.println("10 - Mostre o maior valor da lista: ");
	        numerosAleatoriosInteger.stream()
	                .mapToInt(Integer::intValue)
	                .max()
	                .ifPresent(i -> System.out.println("\t" + i));;

	        int somaDosNumerosPares = numerosAleatoriosInteger.stream()
	                .filter(i -> (i % 2 == 0))
	                .mapToInt(Integer::intValue)
	                .sum();
	        System.out.println("11 - Pegue apenas os números pares e some:\n\t" + somaDosNumerosPares);

	        System.out.println("12 - Mostre a lista na ordem númerica: ");
	        List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream()
	                .sorted(Comparator.naturalOrder())
	                .collect(Collectors.toList());
	        System.out.println("\t" + numerosOrdemNatural);

	        System.out.println("13 - Agrupe os valores ímpares múltiplos de 3 ou de 5:");
	        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger.stream()
	                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
	        System.out.println("\t" + collectNumerosMultiplosDe3E5);
	    }
}
