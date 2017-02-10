package by.epam.tr.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

//Output data to console or file
public class DataOutput {

	private String banner;
	private PrintWriter fileOutput;

	//Output data to console	
	public DataOutput(String banner) {
		this.banner = banner;
		System.out.println(this.banner);
	}

	//Output data to file	
	public DataOutput(String banner, String fileOutputName) throws FileNotFoundException, UnsupportedEncodingException {
		this.banner = banner;
		fileOutput = new PrintWriter(fileOutputName, "UTF-8");
		System.out.println(this.banner);
	}

	public void printInt(int value) {

		if (fileOutput != null) {
			fileOutput.write(value);
		} else {
			System.out.println(value);
		}
	}

	public void printDouble(double value) {

		if (fileOutput != null) {
			fileOutput.write(String.format("%.4f", value));
		} else {
			System.out.println(String.format("%.4f", value));
		}

	}

	public void printStr(String value) {

		if (fileOutput != null) {
			fileOutput.write(value);
		} else {
			System.out.println(value);
		}
	}

	public void close() {
		if (fileOutput != null) {
			fileOutput.close();
		}
	}

}
