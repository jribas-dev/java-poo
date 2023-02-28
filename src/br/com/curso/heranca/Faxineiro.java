package br.com.curso.heranca;

public class Faxineiro extends Funcionario {

	Integer numDependentes;

	public Faxineiro(String nome, Integer idade, double valorHora, int numDependentes) {
		super(nome, idade, valorHora);
		this.numDependentes = numDependentes;
	}

	public Integer getNumDependentes() {
		return numDependentes;
	}

	public void setNumDependentes(Integer numDependentes) {
		this.numDependentes = numDependentes;
	}

	@Override
	public String toString() {
		return "Faxineiro \n{\n\tnumDependentes: " + numDependentes + ",\n\tnome: " + nome + ",\n\tidade: " + idade
				+ ",\n\tvalorHora: " + valorHora + "\n}";
	}

	@Override
	public double calcularSalario(int cargaHoraria) {
		// TODO Auto-generated method stub
		return (super.calcularSalario(cargaHoraria) + (18.99 * this.numDependentes));
	}

}
