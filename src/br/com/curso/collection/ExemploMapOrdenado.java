package br.com.curso.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExemploMapOrdenado {

	public static void main(String[] args) {
		System.out.println("1 - Ordem aleatória:");
		Map<String, Livro> myBooks = new HashMap<>() {
			private static final long serialVersionUID = 1L;
			{
				put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
				put("Duhigg, Charles", new Livro("O poder do hábito", 408));
				put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
			}
		};
		for (Map.Entry<String, Livro> livro : myBooks.entrySet()) {
			System.out.println("\t" + livro.getKey() + " - " + livro.getValue().getNome());
		}

		System.out.println("2 - Ordem de inserção:");
		Map<String, Livro> myBooks2 = new LinkedHashMap<>() {
			private static final long serialVersionUID = 1L;
			{
				put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
				put("Duhigg, Charles", new Livro("O poder do hábito", 408));
				put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
			}
		};
		for (Map.Entry<String, Livro> livro : myBooks2.entrySet()) {
			System.out.println("\t" + livro.getKey() + " - " + livro.getValue().getNome());
		}

		System.out.println("3 - Ordem alfabética de autores:");
		Map<String, Livro> myBooks3 = new TreeMap<>(myBooks2);
		for (Map.Entry<String, Livro> livro : myBooks3.entrySet()) {
			System.out.println("\t" + livro.getKey() + " - " + livro.getValue().getNome());
		}

		System.out.println("4 - Ordem alfabética dos nomes dos livros:");
		Set<Map.Entry<String, Livro>> myBooks4 = new TreeSet<>(new ComparatorNome());
		myBooks4.addAll(myBooks2.entrySet());
		for (Map.Entry<String, Livro> livro : myBooks4) {
			System.out.println("\t" + livro.getKey() + " - " + livro.getValue().getNome());
		}

		System.out.println("5 - Ordem dos livros por nro de páginas:");
		Set<Map.Entry<String, Livro>> myBooks5 = new TreeSet<>(new ComparatorPaginas());
		myBooks5.addAll(myBooks2.entrySet());
		for (Map.Entry<String, Livro> livro : myBooks5) {
			System.out.println("\t" + livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas());
		}

	}

}

class Livro {
	private String nome;
	private Integer paginas;

	public Livro(String nome, Integer paginas) {
		this.nome = nome;
		this.paginas = paginas;
	}

	public String getNome() {
		return nome;
	}

	public Integer getPaginas() {
		return paginas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, paginas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(paginas, other.paginas);
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", paginas=" + paginas + "]";
	}

}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
		return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
	}

}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
		return Integer.compare(o1.getValue().getPaginas(), o2.getValue().getPaginas());
	}

}