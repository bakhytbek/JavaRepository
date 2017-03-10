package by.epam.tr.parser;

import by.epam.tr.constant.Setting;
import by.epam.tr.text.ComponentText;
import by.epam.tr.text.Lexeme;
import by.epam.tr.text.CompositeText;

public class SentenceParser implements ParserChain {

	private ParserChain nextChain;
	
	@Override
	public void setNextChain(ParserChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public ComponentText parse(String value) {
		
		//System.out.println("NEW SENTENCE");

		CompositeText sentence = new CompositeText();
		
		for (String lexeme_value : value.split(Setting.PATTERN_LEXEME)) {
			
			Lexeme lexeme = (Lexeme) nextChain.parse(lexeme_value);
			sentence.add(lexeme);

		}

		return sentence;

	}
	

}
