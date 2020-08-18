
public class Transaction {
	private String date;
	private String type;
	private String isoIn;
	private double amtIn;
	private String isoOut;
	private double amtOut;
	private double rate;
	
	public Transaction(String date, String type, String isoIn, double amtIn, String isoOut, double amtOut,double rate) {
		this.date = date;
		this.type = type;
		this.isoIn = isoIn;
		this.amtIn = amtIn;
		this.isoOut = isoOut;
		this.amtOut = amtOut;
		this.rate = rate;
	}

	public String getDate() {
		return date;
	}

	public String getType() {
		return type;
	}

	public String getIsoIn() {
		return isoIn;
	}

	public double getAmtIn() {
		return amtIn;
	}

	public String getIsoOut() {
		return isoOut;
	}

	public double getAmtOut() {
		return amtOut;
	}

	public double getRate() {
		return rate;
	}
	
	
}
