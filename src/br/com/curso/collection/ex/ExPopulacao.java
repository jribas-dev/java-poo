package br.com.curso.collection.ex;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class ExPopulacao {

	public static void main(String[] args) {
		System.out.println("01- Crie um dicionario com os estados e população:");
		Map<String, Integer> Ufs = new LinkedHashMap<>();
		Ufs.put("PE", 9616621);
		Ufs.put("AL", 3351543);
		Ufs.put("CE", 9187103);
		Ufs.put("RN", 3534265);
		prinUf(Ufs);

		System.out.println("02- Substitua a população de RN por 3.534.165:");
		Ufs.put("RN", 3534165);
		prinUf(Ufs, "RN");

		System.out.println("03- Confira se existe PB no dicionario e adicione com 4.039.277:");
		System.out.println("\tPB existe no dicionario: " + Ufs.containsKey("PB"));
		if (!Ufs.containsKey("PB"))
			Ufs.put("PB", 4039277);
		prinUf(Ufs, "PB");

		System.out.println("04- Exiba a população de PE:");
		prinUf(Ufs, "PE");

		System.out.println("05- Exiba todos estados na ordem de inserção:");
		prinUf(Ufs);

		System.out.println("06- Exiba todos estados em ordem alfabética:");
		Map<String, Integer> UfsOrdem = new TreeMap<>();
		UfsOrdem.putAll(Ufs);
		prinUf(UfsOrdem);

		System.out.println("07- Exiba o estado com menor população:");
		for (Map.Entry<String, Integer> uf : Ufs.entrySet()) {
			if (uf.getValue().equals(Collections.min(Ufs.values())))
				System.out.println("\t" + uf.getKey() + " - " + String.format(Locale.ITALY, "%,d", uf.getValue()));
		}

		System.out.println("08- Exiba o estado com maior população:");
		for (Map.Entry<String, Integer> uf : Ufs.entrySet()) {
			if (uf.getValue().equals(Collections.max(Ufs.values())))
				System.out.println("\t" + uf.getKey() + " - " + String.format(Locale.ITALY, "%,d", uf.getValue()));
		}

		System.out.println("09- Exiba a soma da população:");
		Integer soma = 0;
		for (Iterator<Integer> iterator = Ufs.values().iterator(); iterator.hasNext();) {
			soma += iterator.next();
		}
		System.out.println("\tSOMA: " + String.format(Locale.ITALY, "%,d", soma));

		System.out.println("10- Exiba a média de população:");
		Double media = ((double) soma / (double) Ufs.size());
		System.out.println("\tMEDIA: " + String.format(Locale.ITALY, "%,.2f", media));

		System.out.println("11- Remova os estados com população menor que 4 milhões:");
		for (Iterator<Integer> iterator = Ufs.values().iterator(); iterator.hasNext();) {
			if (iterator.next() < 4000000)
				iterator.remove();
		}
		prinUf(Ufs);

		System.out.println("12- Apague o dicionário, confira se esta vazio:");
		Ufs.clear();
		System.out.println("\tEsta vazio: " + Ufs.isEmpty());
	}

	static void prinUf(Map<String, Integer> Ufs) {
		for (Map.Entry<String, Integer> uf : Ufs.entrySet()) {
			System.out.println("\t" + uf.getKey() + " - " + String.format(Locale.ITALY, "%,d", uf.getValue()));
		}
	}

	static void prinUf(Map<String, Integer> Ufs, String i) {
		System.out.println("\t" + i + " - " + String.format(Locale.ITALY, "%,d", Ufs.get(i)));
	}

}
