import java.io.IOException;

import org.json.simple.parser.ParseException;

/**
 * 
 */

/**
 * @author Stephen Southard
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, ParseException {

		GMEStruct sp = new GMEStruct();

		int maxP = (int) Calculations.maxPercent(sp.timePrice);
		System.out.println(sp.timePrice.get(0));
		System.out.println(sp.timePrice.get(sp.timePrice.size() - 1));
		System.out.println(maxP + " %" + " profit over last 5 days with 5 min trading intervals");

		System.out.println("done");
	}

}
