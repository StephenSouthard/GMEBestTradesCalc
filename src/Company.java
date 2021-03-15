public class Company {
	String ticker;
	String name;
	String price;
	String percentChange;
	String[] fiveMinPercentChanges;

	/*
	 * The fiveMinPercentChanges are from market open to market close. There are 78
	 * five minute intervals between those times.
	 */
	public Company(String ticker, String name, String price, String percentChange) {
		this.ticker = ticker;
		this.name = name;
		this.price = price;
		this.percentChange = percentChange;
		this.fiveMinPercentChanges = new String[78];
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPercentChange() {
		return percentChange;
	}

	public void setPercentChange(String percentChange) {
		this.percentChange = percentChange;
	}

}