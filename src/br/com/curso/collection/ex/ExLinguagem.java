package br.com.curso.collection.ex;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ExLinguagem {

	public static void main(String[] args) {
		Set<LinguagemFavorita> fav = new LinkedHashSet<>();
		fav.add(new LinguagemFavorita("Pascal", LocalDate.of(1995, 2, 14), "Delphi"));
		fav.add(new LinguagemFavorita("Javasript", LocalDate.of(1997, 6, 13), "VS Code"));
		fav.add(new LinguagemFavorita("Java", LocalDate.of(1996, 1, 23), "Eclipse"));

		System.out.println("A - Ordem de inserção:");
		for (LinguagemFavorita f : fav)
			System.out.println("\t" + f.getNome() + " - " + f.getDataCriacao() + " - " + f.getIde());

		System.out.println("\nB - Ordem Natural (nome):");
		Set<LinguagemFavorita> favOrdemNome = new TreeSet<>(fav);
		for (LinguagemFavorita f : favOrdemNome)
			System.out.println("\t" + f.getNome() + " - " + f.getDataCriacao() + " - " + f.getIde());

		System.out.println("\nC - Ordem IDE:");
		Set<LinguagemFavorita> favOrdemIde = new TreeSet<>(new ComparatorIde());
		favOrdemIde.addAll(fav);
		for (LinguagemFavorita f : favOrdemIde)
			System.out.println("\t" + f.getNome() + " - " + f.getDataCriacao() + " - " + f.getIde());

		System.out.println("\nD - Ordem Ano e Nome:");
		Set<LinguagemFavorita> favOrdemAnoNome = new TreeSet<>(new ComparatorAnoNome());
		favOrdemAnoNome.addAll(fav);
		for (LinguagemFavorita f : favOrdemAnoNome)
			System.out.println("\t" + f.getNome() + " - " + f.getDataCriacao() + " - " + f.getIde());

		System.out.println("\nE - Ordem Nome, Ano e IDE:");
		Set<LinguagemFavorita> favOrdemNomeAnoIde = new TreeSet<>(new ComparatorNomeAnoIde());
		favOrdemNomeAnoIde.addAll(fav);
		for (LinguagemFavorita f : favOrdemNomeAnoIde)
			System.out.println("\t" + f.getNome() + " - " + f.getDataCriacao() + " - " + f.getIde());
	}

}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
	private String nome;
	private LocalDate dataCriacao;
	private String ide;

	public LinguagemFavorita(String nome, LocalDate dataCriacao, String ide) {
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.ide = ide;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public String getIde() {
		return ide;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCriacao, ide, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinguagemFavorita other = (LinguagemFavorita) obj;
		return Objects.equals(dataCriacao, other.dataCriacao) && Objects.equals(ide, other.ide)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "LinguagemFavorita [nome=" + nome + ", dataCriacao=" + dataCriacao + ", ide=" + ide + "]";
	}

	@Override
	public int compareTo(LinguagemFavorita o) {
		return this.getNome().compareTo(o.getNome());
	}

}

class ComparatorIde implements Comparator<LinguagemFavorita> {
	@Override
	public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
		return o1.getIde().compareTo(o2.getIde());
	}
}

class ComparatorAnoNome implements Comparator<LinguagemFavorita> {
	@Override
	public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
		int oAno = Integer.compare(o1.getDataCriacao().getYear(), o2.getDataCriacao().getYear());
		if (oAno != 0)
			return oAno;

		return o1.getNome().compareTo(o2.getNome());
	}
}

class ComparatorNomeAnoIde implements Comparator<LinguagemFavorita> {
	@Override
	public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
		int oNome = o1.getNome().compareTo(o2.getNome());
		if (oNome != 0)
			return oNome;

		int oAno = Integer.compare(o1.getDataCriacao().getYear(), o2.getDataCriacao().getYear());
		if (oAno != 0)
			return oAno;

		return o1.getIde().compareTo(o2.getIde());
	}
}