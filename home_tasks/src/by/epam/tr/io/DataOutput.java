package by.epam.tr.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class DataOutput {

	private String banner;
	private PrintWriter fileOutput;

	public DataOutput(String banner) {
		this.banner = banner;
		System.out.println(this.banner);
	}

	public DataOutput(String banner, String fileOutputName) throws FileNotFoundException, UnsupportedEncodingException {
		this.banner = banner;
		fileOutput = new PrintWriter(fileOutputName, "UTF-8");
		fileOutput.write(this.banner);
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
