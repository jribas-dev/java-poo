package br.com.curso.heranca;

public class Funcionario {

	String nome;
	Integer idade;
	double valorHora;

	public Funcionario() {
	}

	public Funcionario(String nome, Integer idade, double valorHora) {
		this.nome = nome;
		this.idade = idade;
		this.valorHora = valorHora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	@Override
	public String toString() {
		return "Funcionario \n{\n\tnome: " + nome + ",\n\tidade: " + idade + ",\n\tvalorHora: " + valorHora + "\n}";
	}

	public double calcularSalario(int cargaHoraria) {
		return (this.valorHora * cargaHoraria);
	}

}
