package by.epam.tr.main;

import by.epam.tr.io.DataInput;
import by.epam.tr.io.DataOutput;
import by.epam.tr.util.Calc;

import java.io.IOException;
import java.util.ArrayList;


public class HomeTask {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Long> values = new ArrayList<Long>();
		ArrayList<Boolean> statuses = new ArrayList<Boolean>();
		
		//--read data from file to array
		DataInput dataInput = new DataInput("data\\input.txt" );
		dataInput.readLong(values, statuses);
		dataInput.close();
		
		//--multiply digits
		Calc.multiplyDigits(values);
		
		//--print data from array to file
		DataOutput dataOutput = new DataOutput("data\\output.txt" ); 
		dataOutput.printLong(values, statuses);
		dataOutput.close();
		
		
		
	}

}
