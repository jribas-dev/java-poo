package br.com.curso.heranca;

public class MainHeranca {

	public static void main(String[] args) {
		Funcionario[] funcionarios = new Funcionario[] { 
				new Vendedor("João", 43, 11.50, 6),
				new Faxineiro("Maria", 31, 9.50, 3), 
				new Gerente("Eloah", 35, 16.50, 12) };
		double salario, folhaPagto = 0;

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getClass() + "\n" + funcionario.nome);
			salario = funcionario.calcularSalario(160);
			folhaPagto += salario;
			System.out.println("Salario: " + salario + "\n");
		}
		System.out.println("==================" + "\nTOTAL FOLHA: " + folhaPagto);
	}

}
