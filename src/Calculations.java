import java.util.ArrayList;

public class Calculations {

	public static float maxPercent(ArrayList<Float> timePrice) {
		float max = 0;
		for (int i = 1; i < timePrice.size(); i++) {
			if (timePrice.get(i) > timePrice.get(i - 1))
				max += timePrice.get(i) - timePrice.get(i - 1);
		}
		return max;
	}

}
