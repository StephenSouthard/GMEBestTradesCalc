import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GMEStruct {
	// change the List and HashMap to be combined into a LinkedHashMap<>();

	String url;
	Document document;
	BarRecord[] data;
	Elements table;
	int sizeOfData;
	JSONObject jsonObject;

	// Constructor for GMEStruct.
	public GMEStruct() throws IOException, ParseException {
		this.url = makeURL();
		setDocument();
		jsonStuff();
//		setData();
	}

	/*
	 * -----------------------------------------------------------------------------
	 * --------------
	 */
	/*
	 * 
	 */
	private String makeURL() {
		String todaysDate = DateFormat.todaysDate();
		String lastWeeksDate = DateFormat.lastWeeksDate();
		String url = "https://fastquote.fidelity.com/service/marketdata/historical/chart/json?productid=research&symbols=GME&startDate="
				+ lastWeeksDate + "-00:00:00&endDate=" + todaysDate
				+ "-23:59:59&barWidth=5&extendedHours=N&quoteType=R&corpActions=Y&timestamp=start&uuid=591a66bc-5209-11df-b5f7-9bc8b53daa77&callback=jQuery111107107642419280338_1615563760051&_=1615563760054";
		System.out.println(lastWeeksDate);
		System.out.println(todaysDate);
		System.out.println(url);
		return url;
	}

	private void jsonStuff() throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(this.url);
		Object obj = jsonparser.parse(reader);
		this.jsonObject = (JSONObject) obj;

		System.out.println(jsonObject.get("Symbol[0]"));
	}

	/*
	 * Sets data of DoublyLinkedList and HashMap
	 */
	private void setDocument() {
		try {
			this.document = Jsoup.connect(this.url).get();
			System.out.println(this.document.toString());
			this.table = this.document.select("div#json");
			System.out.println(this.table.select("Symbol[0]"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Sets percent changes per five minutes from market open (09:30) to market
	 * close (15:55). Saves them all in an array nextCompany.fiveMinPercentChanges.
	 * Uses time open to next time open (5 min later). At 15:55 the percent ends at
	 * time close.
	 */
	private void setData() {
		int i = 0;
		int row = 0;

		for (Element step : this.table) {
			Elements method = step.select("li div.hoverable ul.obj.collapsible");
			for (Element a : method) {
				String s = a.select("li div.hoverable span.type-string").text();
				System.out.println(s);
			}

//				if (element.select())
//					for (Element b : a.select("li")) {
//						row++;
//						switch (row) {
//						case 0:
//							this.data[i] = new BarRecord();
//							this.data[i].dateTime = b.select("span.type-string").text();
//							break;
//						case 5:
//							System.out.println(this.data[i].dateTime);
//							System.out.println(this.data[i].open);
//							System.out.println(this.data[i].close);
//							System.out.println(this.data[i].percent);
//							i++;
//							row = -1;
//							break;
//						default:
//							break;
//						}
//					}
		}
	}

	/*
	 * Sets a specfied index within the nextCompany.fiveMinPercentChanges array.
	 * Called from setFiveMinPercentChanges.
	 */
	private String setPriceOfIndex(Element row, Company nextCompany, int index, String time, String date) {
		System.out.println(date + " " + time);
		return null;

	}
}