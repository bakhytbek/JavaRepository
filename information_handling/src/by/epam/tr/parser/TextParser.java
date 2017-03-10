package by.epam.tr.parser;

import by.epam.tr.constant.Setting;
import by.epam.tr.text.ComponentText;
import by.epam.tr.text.CompositeText;

public class TextParser implements ParserChain {

	private ParserChain nextChain;
	
	@Override
	public void setNextChain(ParserChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public ComponentText parse(String value) {
		
		CompositeText text = new CompositeText();

		for (String paragraph_value : value.split(Setting.PATTERN_PARAGRAPH)) {
			
			CompositeText paragraph = (CompositeText) nextChain.parse(paragraph_value);
			text.add(paragraph);
        
        }
        
        return text;
	}
	
	
	public TextParser() {
		// initialize the chain
		ParagraphParser paragraph = new ParagraphParser();
		SentenceParser sentence = new SentenceParser();
		LexemeParser lexeme = new LexemeParser();
		
		// set the chain of responsibility
		this.setNextChain(paragraph);
		paragraph.setNextChain(sentence);
		sentence.setNextChain(lexeme);
	}
	

}
