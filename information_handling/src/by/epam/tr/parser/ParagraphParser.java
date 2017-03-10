package by.epam.tr.parser;

import by.epam.tr.constant.Setting;
import by.epam.tr.text.ComponentText;
import by.epam.tr.text.CompositeText;

public class ParagraphParser implements ParserChain {
	
	private ParserChain nextChain;

	@Override
	public void setNextChain(ParserChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public ComponentText parse(String value) {
		
		//System.out.println("NEW PARAGRAH");
		
		CompositeText paragraph = new CompositeText();
		
		for (String sentence_value : value.split(Setting.PATTERN_SENTENCE)) {
			
			CompositeText sentence = (CompositeText) nextChain.parse(sentence_value);
			paragraph.add(sentence);

		}
		
		return paragraph;
		
	}

}
