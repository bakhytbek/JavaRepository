package by.epam.tr.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DataInput {

	private Scanner scanner;
	private String banner;
	private FileReader fileInput;

	public DataInput(String banner) {
		this.banner = banner;
		scanner = new Scanner(System.in);
		System.out.println(this.banner);
	}

	public DataInput(String banner, String fileInputName) throws FileNotFoundException {
		this.banner = banner;
		fileInput = new FileReader(fileInputName);
		scanner = new Scanner(fileInput);
		System.out.println(this.banner);
	}

	public int readInt() {

		int result = 0;

		if (scanner.hasNextInt()) {
			result = scanner.nextInt();
		} else {
			scanner.next();
			result = 0;
		}

		return result;
	}

	public double readDouble() {

		double result = 0;

		if (scanner.hasNextDouble()) {
			result = scanner.nextDouble();
		} else {
			scanner.next();
			result = 0;
		}

		return result;
	}

	public void close() throws IOException {
		if (fileInput != null) {
			fileInput.close();
		}
		scanner.close();
	}

}
