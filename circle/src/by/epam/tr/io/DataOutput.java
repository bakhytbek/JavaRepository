package by.epam.tr.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import by.epam.tr.resource.Message;
import by.epam.tr.shape.Circle;


//Print data to file
public class DataOutput {

	public void printCircle(String fileName, ArrayList<Circle> circles) throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter fileOutput = null;
		
		try {
			fileOutput = new PrintWriter(fileName, "UTF-8");
			
			for (int i = 0; i < circles.size(); i++) {
				if (circles.get(i) != null) {
					fileOutput.println(String.format(Message.MSG_RESULT_OUTPUT
							, circles.get(i).getRadius()
							, circles.get(i).getArea()
							, circles.get(i).getPerimeter()));
				} else {
					fileOutput.println(Message.MSG_RESULT_OUTPUT);
				}    
			}

		}
		finally {
			if (fileOutput != null) {
				fileOutput.close();
			}
		}
		
	}



}
