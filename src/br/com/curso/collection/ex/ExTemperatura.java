package br.com.curso.collection.ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExTemperatura {

	public static void main(String[] args) {
		List<Temp> temperaturas = mockList(6);
		System.out.println(temperaturas);

		Double soma = 0d;
		Iterator<Temp> iterator = temperaturas.iterator();
		while (iterator.hasNext())
			soma += iterator.next().getTemperatura();

		Double media = soma / temperaturas.size();
		System.out.println("\nMédia do semestre: " + String.format("%.2f",media) + "°");

		System.out.println("\nMeses acima da média: ");
		iterator = temperaturas.listIterator();
		while (iterator.hasNext()) {
			Temp t = iterator.next();
			if (t.getTemperatura() >= media)
				System.out.println(t);
		}

	}

	public static List<Temp> mockList(int size) {
		List<Temp> list = new ArrayList<Temp>(size);
		for (int i = 1; i <= size; i++) {
			if (i == 1)
				list.add(new Temp("Janeiro", 25.6));
			else if (i == 2)
				list.add(new Temp("Fevereiro", 28.7));
			else if (i == 3)
				list.add(new Temp("Março", 30.3));
			else if (i == 4)
				list.add(new Temp("Abril", 30.7));
			else if (i == 5)
				list.add(new Temp("Maio", 26.4));
			else if (i == 6)
				list.add(new Temp("Junho", 20.2));
		}
		return list;
	}
}

class Temp {
	String mes;
	Double temperatura;

	public Temp(String mes, Double temperatura) {
		this.mes = mes;
		this.temperatura = temperatura;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "Temp [mes=" + mes + ", temperatura=" + temperatura + "]";
	}

}