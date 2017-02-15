package by.epam.tr.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import by.epam.tr.resource.Message;


//Print data to file
public class DataOutput {

	private PrintWriter fileOutput;

	public DataOutput(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		fileOutput = new PrintWriter(fileName, "UTF-8");
	}

	public void printLong(ArrayList<Long> values, ArrayList<Boolean> statuses) {
		
		for (int i = 0; i < values.size(); i++) {
			if (statuses.get(i)) {
				fileOutput.println(Long.toString(values.get(i)));
			} else {
				fileOutput.println(Message.MSG_WRONG_NUMBER);
			}    
		}
	}

	public void printDouble(ArrayList<Double> values, ArrayList<Boolean> statuses) {

		for (int i = 0; i < values.size(); i++) {
			if (statuses.get(i)) {
				fileOutput.println(String.format("%.4f", values.get(i)));
			} else {
				fileOutput.println(Message.MSG_WRONG_NUMBER);
			}    
		}
	}


	public void close() {
		if (fileOutput != null) {
			fileOutput.close();
		}
	}

}
