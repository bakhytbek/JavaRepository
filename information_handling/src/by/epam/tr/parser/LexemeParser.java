package by.epam.tr.parser;

import by.epam.tr.constant.Setting;
import by.epam.tr.text.ComponentText;
import by.epam.tr.text.Lexeme;


public class LexemeParser implements ParserChain {
	
	private ParserChain nextChain;

	@Override
	public void setNextChain(ParserChain nextChain) {
		//this.nextChain = nextChain;
		this.nextChain = this;
	}

	@Override
	public ComponentText parse(String value) {
		
		//System.out.println("******** NEW LEXEME:\"" + value + "\"");
		Lexeme lexeme = new Lexeme();
		
		for (String lexeme_part : value.split(Setting.PATTERN_LEXEME_SPLIT)) {
			
			if (lexeme_part.matches(Setting.PATTERN_WORD_MATCH)) {
				lexeme.setWord(lexeme_part);
			} 
			else if (lexeme.isWord() == 0) {
				lexeme.appendPrefix(lexeme_part);
			} 
			else {
				lexeme.appendPostfix(lexeme_part);
			}
		}

		return lexeme;
	}
	

}
