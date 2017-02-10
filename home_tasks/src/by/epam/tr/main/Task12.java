package by.epam.tr.main;

import by.epam.tr.io.DataOutput;
import by.epam.tr.io.DataInput;
import by.epam.tr.shape.Circle;


public class Task12 {

	public static void main(String[] args) {

		double radius;
		
		//--read/write from console--
		DataInput inputConsole = new DataInput("Please enter raduis of circle: ");
		
		radius = inputConsole.readDouble();
		
		Circle  circle = new Circle(radius);
		
		DataOutput outputConsole = new DataOutput("****** Result of calculation ******");
		
		outputConsole.printStr("Circle area: ");
		outputConsole.printDouble(circle.area());

		outputConsole.printStr("Circle perimeter: ");
		outputConsole.printDouble(circle.perimeter());

		inputConsole.close();
		outputConsole.close();
		

		
	}

}
