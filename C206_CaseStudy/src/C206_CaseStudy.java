import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<MoneyHolding> MoneyHoldingList = new ArrayList<MoneyHolding>();
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		Currency MYR = new Currency("MYR", 3.06, 3.06);
		Currency USD = new Currency("USD", 0.73, 0.73);
		Currency THB = new Currency("THB", 22.88, 22.7);
		Currency TWD = new Currency("TWD", 22.57, 22.25);
		Currency CNY = new Currency("CNY", 5.09, 5.07);
		Currency HKD = new Currency("HKD", 5.68, 5.65);
		Currency JPY = new Currency("JPY", 78.01, 77.04);
		Currency KRW = new Currency("KRW", 878.73, 874.15);
		Currency EUR = new Currency("EUR", 0.62, 0.62);
		Currency GBP = new Currency("GBP", 0.56, 0.56);
		Currency AUD = new Currency("AUD", 1.03, 1.02);
		Currency NZD = new Currency("NZD", 1.12, 1.10);
		Currency IDR = new Currency("IDR", 10638.30, 10250);
		Currency PHP = new Currency("PHP", 38.76, 37.2);
		Currency VND = new Currency("VND", 16666.67, 0);
		Currency INR = new Currency("INR", 51.81, 0);
		Currency CHF = new Currency("CHF", 0.67, 0);
		Currency CAD = new Currency("CAD", 0.97, 0.96);
		currencyList.add(MYR);
		currencyList.add(USD);
		currencyList.add(THB);
		currencyList.add(TWD);
		currencyList.add(CNY);
		currencyList.add(HKD);
		currencyList.add(JPY);
		currencyList.add(KRW);
		currencyList.add(EUR);
		currencyList.add(GBP);
		currencyList.add(AUD);
		currencyList.add(NZD);
		currencyList.add(IDR);
		currencyList.add(PHP);
		currencyList.add(VND);
		currencyList.add(INR);
		currencyList.add(CHF);
		currencyList.add(CAD);
		
		System.out.println(String.format("%-10s: SGD$%-10.2f", "Converted Amount", currencyConverter(1000.0, currencyList)));
		
		
	}
	
	public static MoneyHolding inputMoneyHolding() {
		String iso = Helper.readString("Enter ISO Currency > ");
		double holdingAmt = Helper.readDouble("Enter Holding Amount > ");
		

		MoneyHolding mh= new MoneyHolding(iso, holdingAmt );
		return mh;
		
	}	
	public static void addMoneyHolding(ArrayList<MoneyHolding> MoneyHoldingList, MoneyHolding mh) {

		MoneyHoldingList.add(mh);
		System.out.println("Money holding added");
	}
	
	public static void retrieveCurrency(ArrayList<Currency> currencyList) {
		String output=String.format("%-10s %-10s %-10s\n", "CURRENCY", "BUY RATE", "SELL RATE");
		for (int i=0;i<currencyList.size();i++) {
			String cName = currencyList.get(i).getCname();
			double buyCvalue = currencyList.get(i).getBuyCvalue();
			double sellCvalue = currencyList.get(i).getSellCvalue();
			output += String.format("%-10s %-10.2f %-10.2f\n", cName, buyCvalue, sellCvalue);
		}
		System.out.println(output);
	}
	
	
	public static void searchCurrency(ArrayList<Currency> currencyList) {
		retrieveCurrency(currencyList);
		String search = Helper.readString("Enter Currency to Search > ");
		
		String output=String.format("%-10s %-10s %-10s\n", "CURRENCY", "BUY RATE", "SELL RATE");
		for (int i=0;i<currencyList.size();i++) {
			boolean isSearched = currencyList.get(i).getCname().equals(search);
			if (isSearched) {
				String cName = currencyList.get(i).getCname();
				double buyCvalue = currencyList.get(i).getBuyCvalue();
				double sellCvalue = currencyList.get(i).getSellCvalue();
				output += String.format("%-10s %-10.2f %-10.2f\n", cName, buyCvalue, sellCvalue);
				
			}
		}
		System.out.println(output);
		
	}
	
	public static double currencyConverter(double amount, ArrayList<Currency> currencyList) {
		displaySellOrBuyMenu();
		double sellCvalue = 0.0;
		double buyCvalue = 0.0;
		double convertedAmount = 0.0;
		String search = "";
		
		int option = Helper.readInt("Enter option > ");
		if (option == 1) {
			displayConvertMenu();
			int convertOption = Helper.readInt("Enter option > ");
			if (convertOption == 1) {
				search = Helper.readString("Convert to SGD from > ");
				for (int i=0;i<currencyList.size();i++) {
					boolean isSearched = currencyList.get(i).getCname().equals(search);
					if (isSearched) {
						sellCvalue = currencyList.get(i).getSellCvalue();
					}
				}
				convertedAmount = amount*sellCvalue;
				
			} else if (convertOption == 2) {
				search = Helper.readString("Convert from SGD to > ");
				for (int i=0;i<currencyList.size();i++) {
					boolean isSearched = currencyList.get(i).getCname().equals(search);
					if (isSearched) {
						sellCvalue = currencyList.get(i).getSellCvalue();
					}
				}
				convertedAmount = amount/sellCvalue;
			} else {
				System.out.println("Option invalid");
			}
		} else if (option == 2) {
			displayConvertMenu();
			int convertOption = Helper.readInt("Enter option > ");
			if (convertOption == 1) {
				search = Helper.readString("Convert to SGD from > ");
				for (int i=0;i<currencyList.size();i++) {
					boolean isSearched = currencyList.get(i).getCname().equals(search);
					if (isSearched) {
						buyCvalue = currencyList.get(i).getBuyCvalue();
					} 
				}
				convertedAmount = amount*buyCvalue;
				
			} else if (convertOption == 2) {
				search = Helper.readString("Convert from SGD to > ");
				for (int i=0;i<currencyList.size();i++) {
					boolean isSearched = currencyList.get(i).getCname().equals(search);
					if (isSearched) {
						buyCvalue = currencyList.get(i).getBuyCvalue();
					} 
				}
				convertedAmount = amount/buyCvalue;
			} else {
				System.out.println("Option invalid");
			}
		}
		
		return convertedAmount;
		
	}
	
	public static void displaySellOrBuyMenu() {
		Helper.line(60, "=");
		System.out.println("Currency Menu");
		Helper.line(60, "=");
		System.out.println("1. Sell");
		System.out.println("2. Buy");
		Helper.line(60, "=");
	}
	
	public static void displayConvertMenu() {
		Helper.line(60, "=");
		System.out.println("Convert Menu");
		Helper.line(60, "=");
		System.out.println("1. Convert to SGD");
		System.out.println("2. Convert from SGD");
		Helper.line(60, "=");
	}

}
