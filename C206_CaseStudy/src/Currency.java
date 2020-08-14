
public class Currency {
	private String cname;
	private double buyCvalue;
	private double sellCvalue;
	
	public Currency(String cname, double buyCvalue, double sellCvalue) {
		this.cname = cname;
		this.buyCvalue = buyCvalue;
		this.sellCvalue = sellCvalue;
	}

	public String getCname() {
		return cname;
	}

	public double getBuyCvalue() {
		return buyCvalue;
	}

	public double getSellCvalue() {
		return sellCvalue;
	}

	public void setBuyCvalue(double buyCvalue) {
		this.buyCvalue = buyCvalue;
	}

	public void setSellCvalue(double sellCvalue) {
		this.sellCvalue = sellCvalue;
	}
	
	
	
}
