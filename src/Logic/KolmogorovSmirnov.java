package Logic;

import java.util.ArrayList;

import gui.MainWindows;

public class KolmogorovSmirnov {
	
	private ArrayList<Double> tableKS;
	private ArrayList<NumeroKS> accumulated;
	private ArrayList<Double> ordererlist;
	
	public KolmogorovSmirnov(ArrayList<Double> ordererlist){
		this.ordererlist = ordererlist;
		tableKS = new ArrayList<>();
		fillTable();
	}

	//establecer la uniformidad
	public boolean estimateUniformity(){
		double difference = 0;
		double dalfa = 0;
		if(ordererlist.size()<21)
			dalfa=tableKS.get(ordererlist.size()-1);
		else if (ordererlist.size()>50)
			dalfa=1.36/Math.sqrt(ordererlist.size());
		else
			dalfa=tableKS.get((ordererlist.size()/5)+15);
		for (int i = 0; i < ordererlist.size(); i++) {
			NumeroKS f = new NumeroKS();
			f.setRandomnumber(ordererlist.get(i));
			f.setAccumulatedprovision((double)(i+1)/ordererlist.size());
			f.setDifference(Math.abs(f.getRandomnumber()-f.getAccumulatedprovision()));
			if(f.getDifference()>difference)
				difference = f.getDifference();
		}
		System.out.println("Alfa:"+dalfa);
		MainWindows.getInstancia().dalfa.setText("Alfa: "+dalfa);
		System.out.println("Diferencia maxima:"+difference);
		MainWindows.getInstancia().difference.setText("Diferencia maxima: "+difference);
		if(difference<=dalfa)
			return true;
		else
			return false;
	}
	
	
	public void fillTable(){
		tableKS.add(0.975);
		tableKS.add(0.842);
		tableKS.add(0.708);
		tableKS.add(0.624);
		tableKS.add(0.565);
		tableKS.add(0.521);
		tableKS.add(0.486);
		tableKS.add(0.457);
		tableKS.add(0.432);
		tableKS.add(0.410);
		tableKS.add(0.391);
		tableKS.add(0.375);
		tableKS.add(0.361);
		tableKS.add(0.349);
		tableKS.add(0.338);
		tableKS.add(0.328);
		tableKS.add(0.318);
		tableKS.add(0.309);
		tableKS.add(0.301);
		tableKS.add(0.294);
		tableKS.add(0.270);
		tableKS.add(0.240);
		tableKS.add(0.230);
		tableKS.add(0.210);
		tableKS.add(0.200);
		tableKS.add(0.190);
	}
	
}
