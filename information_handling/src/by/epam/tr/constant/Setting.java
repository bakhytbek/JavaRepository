package by.epam.tr.constant;

public class Setting {
	
	public static final String PATTERN_PARAGRAPH = "(?<=[\\x0A])";
	public static final String PATTERN_SENTENCE = "(?<=[\\.|\\?|\\!])";
	public static final String PATTERN_LEXEME = "(?<=[\\x20])";
	
	public static final String PATTERN_LEXEME_SPLIT = "((?<=[\\p{Blank}|,|;|:])|(?=[\\p{Blank}|,|;|:|.|!|?]))";
	public static final String PATTERN_WORD_MATCH = ".*(\\w).*";
	
	public static final String LOG_ERROR_FILE_READ = "Can not read from file: \"%s\"";
	
	private static int uniqueId;
	
	public static int getUniqueId () {
		return ++uniqueId;
	}

}
