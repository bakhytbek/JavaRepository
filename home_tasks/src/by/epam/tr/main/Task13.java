package by.epam.tr.main;

import by.epam.tr.io.DataOutput;
import by.epam.tr.util.Calc;
import by.epam.tr.io.DataInput;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;



public class Task13 {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		int value;
		
		//--read/write from console--
		DataInput inputConsole = new DataInput("Please enter interger number: ");
		
		value = inputConsole.readInt();
		value = Calc.multiplyDigits(value);

		DataOutput outputConsole = new DataOutput("****** Result of calculation ******");
		outputConsole.printInt(value);

		inputConsole.close();
		outputConsole.close();
		

		//--read/write from file--
		DataInput inputConsole2 = new DataInput("file reading...", ".\\resource\\input13.txt" );
		DataOutput outputConsole2 = new DataOutput("Result of calculation: ", ".\\resource\\output13.txt");
		
		value = inputConsole2.readInt();
		value = Calc.multiplyDigits(value);
		outputConsole2.printInt(value);

		inputConsole2.close();
		outputConsole2.close();

		
	}

}
