package Logic;

import java.util.ArrayList;

public class Congruential {

	private int x = 0;
	private int a = 0;
	private int c = 0;
	private int mod = 0;
	private int type;
	private double randomnumber;
	private ArrayList<Double> lista; 

	public Congruential(int x, int a, int c, int mod, int type){
		this.x =x;
		this.a = a;
		this.c = c;
		this.mod = mod;
		this.type = type;
		this.lista = new ArrayList<>();
		next();
	}
	
	public Congruential(int x, int a, int mod, int type){
		this.x =x;
		this.a = a;
		this.mod = mod;
		this.type = type;
		this.lista = new ArrayList<>();
		next();
	}
	
	public boolean validate(){
		if(lista.contains(randomnumber))
			return false;
		else
			lista.add(randomnumber);
		return true;		
	}
	
	public void next(){
		if(type==2){
			x = (a * x + c) % mod;
			this.randomnumber = (double)x/mod;
		}else{
			x = (a * x) % mod;
			this.randomnumber = (double)x/100;
		}
	}

	public ArrayList<Double> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Double> lista) {
		this.lista = lista;
	}	

}
