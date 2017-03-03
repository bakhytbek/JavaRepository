package by.epam.tr.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import by.epam.tr.shape.Circle;

//Input data from file
public class DataInput {

	public void readCircle(String fileName, ArrayList<Circle> circles) throws IOException {

		String value;
		double radius;
		BufferedReader fileInput = null;

		try {

			fileInput = new BufferedReader(new FileReader(fileName));		
			
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
		
		 
				
		finally {
			if (fileInput != null) {
				fileInput.close();
			}
		}
		
	}
	

}
