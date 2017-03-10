package by.epam.tr.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.tr.constant.Setting;


//Input data from file
public class DataInput {
	
	private static Logger logger = LogManager.getLogger(DataInput.class.getName());

	public static String readFile(String fileName) {

		try  {
			Path path = Paths.get(fileName);
			byte[] content = Files.readAllBytes(path);
			return new String(content, StandardCharsets.UTF_8);
		}
		catch (IOException e) {
			//log4j
			logger.error(String.format(Setting.LOG_ERROR_FILE_READ, fileName));
			return null;		
		}
		 
	}
}

