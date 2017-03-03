package by.epam.tr.constant;

public class Setting {
	
	public static final String PREFIX_COMMENT = "//";
	
	public static final String PREFIX_PASSENGER_WAGON = "P";
	public static final String PREFIX_LOCOMOTIVE = "L";

	public static final String DELIMITER_FIELD = ",";
	public static final String FORMAT_DATE = "dd.MM.yyyy";
	

	public static final String LOG_ERROR_FILE_READ = "Can not read from file: \"%s\"";
	
	//wagon parse
	public static final String LOG_ERROR_INVALID_WAGON_CODE = "Invalid wagon code: \"%s\"; line: \"%s\"";
	public static final String LOG_ERROR_INVALID_ENGINE_TYPE = "Invalid engine type: \"%s\" line: \"%s\"";
	public static final String LOG_ERROR_INVALID_SERVICE_TYPE = "Invalid service type: \"%s\"; line: \"%s\"";
	public static final String LOG_ERROR_INVALID_DATE_FORMAT = "Invalid date format: \"%s\"; line: \"%s\"";
	public static final String LOG_ERROR_INVALID_WAGON_FORMAT = "Invalid wagon format; line: \"%s\"";
	

	//train parse
	public static final String LOG_ERROR_INVALID_TRAIN_FORMAT = "Invalid train format; line: \"%s\"";
	public static final String LOG_ERROR_INVALID_TRAIN_WAGON = "Can not find wagon; line: \"%s\"";
	public static final String LOG_ERROR_INVALID_TRAIN_WAGON_ADD = "Wagon is already added to train; line: \"%s\"";
	
}
