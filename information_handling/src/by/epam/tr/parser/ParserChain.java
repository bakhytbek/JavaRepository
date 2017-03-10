package by.epam.tr.parser;

import by.epam.tr.text.ComponentText;

public interface ParserChain {

	public void setNextChain(ParserChain nextChain);
	
	public ComponentText parse(String value);

}