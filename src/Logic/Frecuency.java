package Logic;

public class Frecuency {

	private double lowerlimit;
	private double upperlimit;
	private int quantity;
	
	public Frecuency(double lowerlimit, double upperlimit){
		this.lowerlimit = lowerlimit;
		this.upperlimit = upperlimit;
		this.quantity = 0;
	}

	public double getLowerlimit() {
		return lowerlimit;
	}

	public void setLowerlimit(double lowerlimit) {
		this.lowerlimit = lowerlimit;
	}

	public double getUpperlimit() {
		return upperlimit;
	}

	public void setUpperlimit(double upperlimit) {
		this.upperlimit = upperlimit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
