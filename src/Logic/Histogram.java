package Logic;

import java.util.ArrayList;

import gui.MainWindowsHistogram;

public class Histogram {

	public void prueba(double interval, ArrayList<Double> list) {
		Frecuency[] rep = new Frecuency[(int) (1 / interval + 1)]; // Repeticiones
		double currentfrecuency = 0;
		int index = 0;
		Frecuency f;
		while (currentfrecuency < 1.0) {
			if (currentfrecuency + interval > 1)
				f = new Frecuency(currentfrecuency, 1);
			else
				f = new Frecuency(currentfrecuency, currentfrecuency + interval);
			rep[index] = f;
			index++;
			currentfrecuency += interval;
		}
		for (int i = 0; i < list.size(); i++) {
			// int ca = 0; // Cantidad (frecuencia)
			for (int j = 0; j < rep.length; j++) {
				if (list.get(i) >= rep[j].getLowerlimit() && list.get(i) < rep[j].getUpperlimit()) {
					rep[j].setQuantity(rep[j].getQuantity() + 1);
				}
			}
		}
		for (int j = 0; j < rep.length; j++) {
			System.out.print(Math.round(rep[j].getLowerlimit() * 1000.0) / 1000.0 + " - "
					+ Math.round(rep[j].getUpperlimit() * 1000.0) / 1000.0 + " : ");
			int k = 0;
			while (k < rep[j].getQuantity()) {
				System.out.print("*"); // Un '*' por cada punto frecuencial
				k++;
			}
			System.out.println();
			// Histograma interfaz grafica.
			if (Math.round(rep[j].getLowerlimit() * 1000.0) / 1000.0<1.0)
				MainWindowsHistogram.getInstancia().draw(Math.round(rep[j].getLowerlimit() * 1000.0) / 1000.0 + " - "
						+ Math.round(rep[j].getUpperlimit() * 1000.0) / 1000.0 + " : ", k, j+1);
		}
	}

}
