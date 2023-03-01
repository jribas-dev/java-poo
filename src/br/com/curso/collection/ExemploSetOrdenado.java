package br.com.curso.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSetOrdenado {

	public static void main(String[] args) {
		Set<Serie> minhasSeries = new HashSet<>();
		minhasSeries.add(new Serie("Got", "fantasia", 60));
		minhasSeries.add(new Serie("Dark", "drama", 60));
		minhasSeries.add(new Serie("Friends", "comédia", 30));
		
		System.out.println(minhasSeries+"\n");
		for (Serie serie: minhasSeries)
			System.out.println(serie.getNome() +" - "+ serie.getGenero() +" - " + serie.getTempo());
		
		System.out.println("\n01 - Exibir na ordem natural (TempoEpisodio)");
		Set<Serie> ordem1 = new TreeSet<>(minhasSeries);
		System.out.println("\t" + ordem1);

		System.out.println("\n02 - Exibir na ordem nome / genero / tempo");
		Set<Serie> ordem2 = new TreeSet<>(new ComparatorSerie());
		ordem2.addAll(minhasSeries);
		System.out.println("\t" + ordem2);
	}

}

class Serie implements Comparable<Serie> {
	private String nome;
	private String genero;
	private Integer tempo;

	public Serie(String nome, String genero, Integer tempo) {
		this.nome = nome;
		this.genero = genero;
		this.tempo = tempo;
	}

	public String getNome() {
		return nome;
	}

	public String getGenero() {
		return genero;
	}

	public Integer getTempo() {
		return tempo;
	}

	@Override
	public String toString() {
		return "Serie [nome=" + nome + ", genero=" + genero + ", tempo=" + tempo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(genero, nome, tempo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		return Objects.equals(genero, other.genero) && Objects.equals(nome, other.nome)
				&& Objects.equals(tempo, other.tempo);
	}

	@Override
	public int compareTo(Serie o) {
		int oTempo = Integer.compare(this.getTempo(), o.getTempo());
		if (oTempo != 0) return oTempo;

		int oGenero = this.getGenero().compareToIgnoreCase(o.getGenero());
		if (oGenero != 0) return oGenero;

		return Integer.compare(this.hashCode(), o.hashCode()); 
	}

}

class ComparatorSerie implements Comparator<Serie> {

	@Override
	public int compare(Serie o1, Serie o2) {
		int oNome = o1.getNome().compareTo(o2.getNome());
		if (oNome != 0) return oNome;

		int oGenero = o1.getGenero().compareTo(o2.getGenero());
		if (oGenero != 0) return oGenero;

		int oTempo = Integer.compare(o1.getTempo(), o2.getTempo());
		if (oTempo != 0) return oTempo;

		return Integer.compare(o1.hashCode(), o2.hashCode());
	}
	
}