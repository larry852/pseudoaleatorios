package Logic;

import java.util.ArrayList;

public class Operation {

	private long seed;
	private int digits;
	private ArrayList<Double> lista; 

	public Operation(int number, int digits){
		lista = new ArrayList<>();
		this.seed = number;
		this.digits = digits;
		next();
	}
	
	private int lengthdigits(){
		int cont=1; long aux=this.seed;
		while(aux>10){
			aux/=10;
			cont++;
		}
		return cont;
	}
	
	public boolean validate(){	
		if(lista.contains(this.seed/Math.pow(10, this.digits)))
			return false;
		else
			lista.add(this.seed/Math.pow(10, this.digits));
		return true;
	}
	
	public void next(){
		// elevar al cuadrado
		this.seed = this.seed*this.seed;
		// extraer la cantidad de digitos a la mitad
		int lengthdigits=lengthdigits();
		this.seed = (long) (this.seed/Math.pow(10, ((lengthdigits-this.digits)/2)));
		// dividir el resultado en una potencia de 10
		this.seed = (long) (this.seed%Math.pow(10, this.digits));
	}

	public ArrayList<Double> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Double> lista) {
		this.lista = lista;
	}
	
	
	
}
