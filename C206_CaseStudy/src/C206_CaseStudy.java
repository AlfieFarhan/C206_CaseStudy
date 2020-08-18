import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<MoneyHolding> MoneyHoldingList = new ArrayList<MoneyHolding>();
		MoneyHoldingList.add(new MoneyHolding("USD", 3500.00));
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		Currency MYR = new Currency("MYR","Malaysian Ringgit", 3.06, 3.06);
		Currency USD = new Currency("USD", "US Dollar", 0.73, 0.73);
		Currency THB = new Currency("THB", "Thai Baht", 22.88, 22.7);
		Currency TWD = new Currency("TWD", "Taiwan Dollar", 22.57, 22.25);
		Currency CNY = new Currency("CNY", "Chinese Yuan(RMB)", 5.09, 5.07);
		Currency HKD = new Currency("HKD", "Hong Kong Dollar", 5.68, 5.65);
		Currency JPY = new Currency("JPY", "Japanese Yen", 78.01, 77.04);
		Currency KRW = new Currency("KRW", "South Korean Won", 878.73, 874.15);
		Currency EUR = new Currency("EUR", "Euro", 0.62, 0.62);
		Currency GBP = new Currency("GBP", "British Pounds", 0.56, 0.56);
		Currency AUD = new Currency("AUD", "Australian Dollar", 1.03, 1.02);
		Currency NZD = new Currency("NZD", "New Zealand Dollar", 1.12, 1.10);
		Currency IDR = new Currency("IDR", "Indonesian Rupiah", 10638.30, 10250);
		Currency PHP = new Currency("PHP", "Philippine Peso", 38.76, 37.2);
		Currency VND = new Currency("VND", "Vietnamese Dong", 16666.67, 0);
		Currency INR = new Currency("INR", "Indian Rupee", 51.81, 0);
		Currency CHF = new Currency("CHF", "Swiss Francs", 0.67, 0);
		Currency CAD = new Currency("CAD", "Canadian Dollar", 0.97, 0.96);
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
		
		searchRateByCurrency(currencyList, "NZD");
		
		C206_CaseStudy.addMoneyHolding(MoneyHoldingList, inputMoneyHolding() );
		
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
	
	
	public static void searchRateByCurrency(ArrayList<Currency> currencyList, String search) {
		
		String output=String.format("%-10s %-20s %-10s %-10s\n", "ISO", "CURRENCY", "BUY RATE", "SELL RATE");
		for (int i=0;i<currencyList.size();i++) {
			boolean isSearched = currencyList.get(i).getIso().equals(search);
			if (isSearched) {
				String iso = currencyList.get(i).getIso();
				String cName = currencyList.get(i).getCurrencyName();
				double buyCvalue = currencyList.get(i).getBuyRate();
				double sellCvalue = currencyList.get(i).getSellRate();
				output += String.format("%-10s %-20s %-10.2f %-10.2f\n", iso, cName, buyCvalue, sellCvalue);
				
			}
		}
		System.out.println(output);
		
	}
	
	public static void convertCurrency(ArrayList<Currency> currencyList) {
		String type = Helper.readString("Enter Type of transaction > ");
		String cIn = Helper.readString("Enter Currency In > ");
		double amtIn = Helper.readDouble("Enter Amount In > ");
		String cOut = Helper.readString("Enter Currency Out > ");
		double convertedAmount = 0.0;
		
		
		for (int i=0;i<currencyList.size();i++) {
			boolean isSearched = currencyList.get(i).getIso().equals(cOut);
			if (type.equals("SELL")) {
				if (isSearched) {
					convertedAmount = currencyList.get(i).getSellRate()*amtIn;
					System.out.println(String.format("SELLING %s %.2f for %s %.2f", cOut, convertedAmount, cIn, amtIn));
				}
			} else if (type.equals("BUY")) {
				if (isSearched) {
					convertedAmount = currencyList.get(i).getBuyRate()*amtIn;
					System.out.println(String.format("BUYING %s %.2f for %s %.2f", cOut, convertedAmount, cIn, amtIn));
				}
			}
		}
		
	}
	

}
