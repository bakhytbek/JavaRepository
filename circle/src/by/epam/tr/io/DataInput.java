package by.epam.tr.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import by.epam.tr.shape.Circle;

import java.io.FileNotFoundException;

//Input data from file
public class DataInput {

	private BufferedReader fileInput;

	public DataInput(String fileName) throws FileNotFoundException {

		fileInput = new BufferedReader(new FileReader(fileName));

	}

	public void readCircle(ArrayList<Circle> circles) throws IOException {

		String value;
		double radius;
		
		while ((value = fileInput.readLine()) != null) {
			
			try {
				radius = Double.parseDouble(value);
				if (radius > 0) {
					circles.add(new Circle(radius));
				} else {
					circles.add(null);
				} 
			}
			catch (NumberFormatException e) {
				circles.add(null);
			}
			
		}
	}
	
	
	public void close() throws IOException {
		if (fileInput != null) {
			fileInput.close();
		}
	}

}
