import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GMEStruct {
	// change the List and HashMap to be combined into a LinkedHashMap<>();

	String url;
	Document document;
	ArrayList<Float> timePrice;

	// Constructor for GMEStruct.
	public GMEStruct() throws IOException, ParseException {
		this.url = makeURL();
		setDocument();
		this.timePrice = new ArrayList<Float>();
		setData();
	}

	/*
	 * Set the url using todays date and lastweek's date
	 */
	private String makeURL() {
		String todaysDate = DateFormat.todaysDate();
		String lastWeeksDate = DateFormat.lastWeeksDate();
		System.out.println("Enter stock ticker symbol");
		Scanner in = new Scanner(System.in);
		String ticker = in.nextLine().toUpperCase();
		String url = "https://fastquote.fidelity.com/service/marketdata/historical/chart/json?productid=research&symbols="
				+ ticker + "&startDate=" + lastWeeksDate + "-00:00:00&endDate=" + todaysDate
				+ "-23:59:59&barWidth=5&extendedHours=N&quoteType=R&corpActions=Y&timestamp=start&uuid=591a66bc-5209-11df-b5f7-9bc8b53daa77&callback=jQuery111107107642419280338_1615563760051&_=1615563760054";
		return url;
	}

	/*
	 * Sets data of DoublyLinkedList and HashMap
	 */
	private void setDocument() {
		try {
			this.document = Jsoup.connect(this.url).get();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Set timePrice array using data from the document which contains JSon info.
	 */
	private void setData() {

		int p1 = this.document.body().ownText().indexOf("BarRecord");
		StringBuilder sb = new StringBuilder(this.document.body().ownText());
		sb.delete(0, p1);
		p1 = sb.indexOf("\"cl\"");
		sb.delete(0, p1 + 8);
		float price = 0;
		while (p1 >= 0) {
			p1 = sb.indexOf("\"");
			price = Float.parseFloat(sb.substring(0, p1).toString());
			this.timePrice.add(price);
			p1 = sb.indexOf("cl");
			sb.delete(0, p1 + 7);
		}

	}
}