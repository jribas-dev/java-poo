package br.com.curso.heranca;

public class Vendedor extends Funcionario {
	double percComissao;

	public Vendedor(String nome, Integer idade, double valorHora, double percComissao) {
		super(nome, idade, valorHora);
		this.percComissao = percComissao;
	}

	public double getPercComissao() {
		return percComissao;
	}

	public void setPercComissao(double percComissao) {
		this.percComissao = percComissao;
	}

	@Override
	public String toString() {
		return "Vendedor \n{\n\tpercComissao: " + percComissao + ",\n\tnome: " + nome + ",\n\tidade: " + idade
				+ ",\n\tvalorHora: " + valorHora + "\n}";
	}

	@Override
	public double calcularSalario(int cargaHoraria) {
		return (super.calcularSalario(cargaHoraria) * (1 + percComissao / 100));
	}

}
