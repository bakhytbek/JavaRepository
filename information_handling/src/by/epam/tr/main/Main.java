package by.epam.tr.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.tr.action.Action;
import by.epam.tr.io.DataInput;
import by.epam.tr.parser.TextParser;
import by.epam.tr.text.Lexeme;
import by.epam.tr.text.CompositeText;

public class Main {

	private static Logger logger = LogManager.getLogger(DataInput.class.getName());
	
	public static void main(String[] args) {
		
		CompositeText text = (CompositeText) new TextParser().parse(DataInput.readFile("data\\text1.txt"));

		//should be mutable variable
		int[] paragraphId = {0};
		int[] sentenceId = {0};
		int[] lexemeId = {0};

		
		//print text
		logger.info("***********************************************   TEXT   ***********************************************");
		logger.info(text);
		
		//print paragraph
		logger.info("***********************************************   PARAGRAPHS  *******************************************");
		text.getChild().forEach(paragraph->logger.info("PARAGRAH_ID=" + String.valueOf(++paragraphId[0]) + " \""  + paragraph + "\""));
		

		//print sentence
		logger.info("***********************************************   SENTENCES  *******************************************");
		text.getChild().forEach(paragraph->paragraph.getChild()
			           .forEach(sentence->logger.info("SENTENCE_ID=" + String.valueOf(++sentenceId[0]) + " \""  + sentence + "\"")));
		
		
		//print lexeme
		paragraphId[0] = 0;
		sentenceId[0] = 0;
		
		logger.info("************************************************   LEXEMES  *******************************************");
		text.getChild().forEach(paragraph->{paragraphId[0]++; paragraph.getChild()
			           .forEach(sentence->{sentenceId[0]++; sentence.getChild()
			           .forEach(lexeme->logger.info( "Paragraph_id=" + String.valueOf(paragraphId[0]) +
			        		                         ", Sentence_id=" + String.valueOf(sentenceId[0]) +  
			        		                         ", Lexeme_id=" + String.valueOf(++lexemeId[0]) +": \"" 
			        		                                        + lexeme + "\"" 
			        		                                        + " [" +  ((Lexeme)lexeme).getWord() + "]" ));});});
	
		
		

		//print word count
		logger.info("***********************************************   WORD COUNT  *******************************************");
		logger.info(Action.wordCount(text));
		

		//print sentences with word
		logger.info("***************************   SENTENCE WITH WORD COUNT (REAL SENTENCES)  *********************************");
		logger.info(Action.sentenceWithWordCount(text));
		
		sentenceId[0] = 0;
		logger.info("***************************   SENTENCE WITH WORD (REAL SENTENCES)  ***************************************");
		text.getChild().forEach(paragraph->{paragraph.getChild()
			           .forEach(sentence->{if (Action.wordCount((CompositeText)sentence) > 0) logger.info("SENTENCE_ID=" + String.valueOf(++sentenceId[0]) + " \""  + sentence + "\""); ;});;});
		
	}
}
