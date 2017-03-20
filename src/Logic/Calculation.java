package Logic;

import java.util.ArrayList;

public class Calculation {
	
	private ArrayList<Double> list;
	
	public Calculation(ArrayList<Double> listoriginal){
		this.list = listoriginal;
	}
	
	public double calculateAverage(){
		double average = 0;
		for (int i = 0; i < list.size(); i++) {
			average += list.get(i);
		}
		average /= list.size();
		return average;
	}
	
	public double calculateVariance(){
		double variance = 0;
		double average = calculateAverage();
		for (int i = 0; i < list.size(); i++) {
			variance += Math.pow((list.get(i)-average),2);
		}
		variance /= list.size();
		return variance;
	}

}
