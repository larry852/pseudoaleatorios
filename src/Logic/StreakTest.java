package Logic;

import java.util.ArrayList;

import gui.MainWindows;

public class StreakTest {

	/**Test de rachas**/

	ArrayList<Double> originallist;
	ArrayList<Double> ordererlist;
	private double median; //mediana
	private double lowerlimit = -1.96;//los limites de Z depende del alfa escogido(0.5) -> nivel de significaci�n
	private double upperlimit = 1.96;
	private int n1;
	private int n2;


	public StreakTest(ArrayList<Double> list, ArrayList<Double> ordenerlist){
		this.ordererlist = ordenerlist;
		this.originallist = list; 		
		//se encesitan dos listas una ordenada para sacar la mediana y la otra para ca�cular las rachas
		calculateMedian();
	}

	public boolean acceptIndependence(){
		n1 = 1;
		double streak = countStreaks();
		n2 = originallist.size() - n1;
		System.out.println(n1+" "+n2);
		System.out.println("Mediana: "+median);
		MainWindows.getInstancia().median.setText("Mediana: "+median);
		System.out.println("rachas: "+streak);
		MainWindows.getInstancia().streak.setText("Rachas: "+streak);
		double statisticAverage = ((2*n1*n2)/(n1+n2))+1;
		double deviation = Math.sqrt(((2*n1*n2)*((2*n1*n2)-n1-n2))/
				((Math.pow((n1+n2), 2))*(n1+n2-1)));
		double z = (streak - statisticAverage) / deviation;
		System.out.println("Z: "+z);
		MainWindows.getInstancia().z.setText("Z: "+z);
		if(z<lowerlimit || z>upperlimit) //Si se sale del area bajo la curva la hipotesis de independencia es rechazada
			return false;
		else
			return true;
	}
	
	private void calculateMedian(){
		if(ordererlist.size()%2==1){
			median = ordererlist.get(ordererlist.size()/2);
		}else{
			median = (ordererlist.get(ordererlist.size()/2)
					+ ordererlist.get((ordererlist.size()/2)-1))/2;
		}
	}

	//metodo para calcular las rachas
	private int countStreaks(){
		boolean previous = false;
		boolean current;
		int streak = 1;  //rachas
		if(originallist.get(0)<median)
			previous = true;
		for (int i = 1; i < originallist.size(); i++) {
			if(originallist.get(i)<=median)
				current = true;
			else
				current = false;			
			if(previous != current)
				streak++;
			if(streak%2!=0)
				n1++;
			previous = current;
		}
		return streak;
	}

}
