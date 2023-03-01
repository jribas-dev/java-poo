package br.com.curso.collection.ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExTemperatura {

	public static void main(String[] args) {
		List<Temp> temperaturas = mockList();
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

	public static List<Temp> mockList() {
		String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho"};
		List<Temp> list = new ArrayList<Temp>();
		list.add(new Temp(meses[0], 25.6));
		list.add(new Temp(meses[1], 28.7));
		list.add(new Temp(meses[2], 30.3));
		list.add(new Temp(meses[3], 30.7));
		list.add(new Temp(meses[4], 26.4));
		list.add(new Temp(meses[5], 20.2));
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

	public Double getTemperatura() {
		return temperatura;
	}

	@Override
	public String toString() {
		return "[mes=" + mes + ", temperatura=" + temperatura + "]";
	}

}