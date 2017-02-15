package by.epam.tr.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

//Input data from file
public class DataInput {

	private BufferedReader fileInput;

	public DataInput(String fileName) throws FileNotFoundException {

		fileInput = new BufferedReader(new FileReader(fileName));

	}

	public void readLong(ArrayList<Long> values, ArrayList<Boolean> statuses) throws IOException {

		String value;
		
		while ((value = fileInput.readLine()) != null) {
			
			//System.out.println(value);
			try {
				values.add(Long.parseLong(value));
				statuses.add(true);
			}
			catch (NumberFormatException e) {
				values.add(0L);
				statuses.add(false);
			}
			
		}
	}


	public void readDouble(ArrayList<Double> values, ArrayList<Boolean> statuses) throws IOException {

		String value;
		values = new ArrayList<Double>();
		statuses = new ArrayList<Boolean>();
		
		
		while ((value = fileInput.readLine()) != null) {
			
			//System.out.println(value);
			try {
				values.add(Double.parseDouble(value));
				statuses.add(true);
			}
			catch (NumberFormatException e) {
				values.add(0D);
				statuses.add(false);
			}
			
		}
	}


	public void close() throws IOException {
		if (fileInput != null) {
			fileInput.close();
		}
	}

}
