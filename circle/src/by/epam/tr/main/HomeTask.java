package by.epam.tr.main;

import by.epam.tr.calc.Calc;
import by.epam.tr.io.DataInput;
import by.epam.tr.io.DataOutput;
import by.epam.tr.shape.Circle;

import java.io.IOException;
import java.util.ArrayList;


public class HomeTask {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Circle> circles = new ArrayList<Circle>();
		
		//--read data from file to array
		DataInput dataInput = new DataInput();
		dataInput.readCircle("data\\input.txt", circles);
		
		//--calculate area and perimiter
		Calc.calcCircleArea(circles);
		Calc.calcCirclePerimeter(circles);
		
		//--print data from array to file
		DataOutput dataOutput = new DataOutput();
		dataOutput.printCircle("data\\output.txt", circles);
		
		
		
	}

}
