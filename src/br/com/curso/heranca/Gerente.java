package br.com.curso.heranca;

public class Gerente extends Funcionario {

	double percBonus;

	public Gerente(String nome, Integer idade, double valorHora, double percBonus) {
		super(nome, idade, valorHora);
		this.percBonus = percBonus;
	}

	public double getPercBonus() {
		return percBonus;
	}

	public void setPercBonus(double percBonus) {
		this.percBonus = percBonus;
	}

	@Override
	public String toString() {
		return "Gerente \n{\n\tpercBonus: " + percBonus + ",\n\tnome: " + nome + ",\n\tidade: " + idade
				+ ",\n\tvalorHora: " + valorHora + "\n}";
	}

	@Override
	public double calcularSalario(int cargaHoraria) {
		return (super.calcularSalario(cargaHoraria) * (1 + percBonus / 100));
	}

}
