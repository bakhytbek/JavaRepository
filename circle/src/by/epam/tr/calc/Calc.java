package by.epam.tr.calc;

import java.util.ArrayList;
import by.epam.tr.shape.Circle;

public final class Calc {

	private Calc() {}

	public static void calcCircleArea  (ArrayList<Circle> circles) {
		
		for (int i = 0; i < circles.size(); i++) {
			if  (circles.get(i) != null) {
				circles.get(i).setArea(Math.PI * Math.pow(circles.get(i).getRadius(), 2));
			}
		}
	}
	
	public static void calcCirclePerimeter  (ArrayList<Circle> circles) {
		
		for (int i = 0; i < circles.size(); i++) {
			if  (circles.get(i) != null) {
				circles.get(i).setPerimeter(2 * Math.PI * circles.get(i).getRadius());
			}
		}
	}

}
