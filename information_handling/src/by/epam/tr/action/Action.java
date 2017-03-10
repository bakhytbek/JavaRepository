package by.epam.tr.action;

import java.util.HashSet;
import by.epam.tr.text.CompositeText;
import by.epam.tr.text.Lexeme;

public class Action {
	
	public static int wordCount (CompositeText text) {
		
		int[] result= {0};
		
		if ((text.getChild() !=null) && 
			(text.getChild().get(0) instanceof Lexeme))  {
			
			//sentence
			text.getChild().forEach(lexeme->{result[0] = result[0] + ((Lexeme)lexeme).isWord();});
		} 
		else if ((text.getChild() !=null) && 
				 (text.getChild().get(0).getChild()  !=null) &&
				 (text.getChild().get(0).getChild().get(0) instanceof Lexeme)) {
			
			//paragraph
			text.getChild().forEach(sentence-> {sentence.getChild()
						   .forEach(lexeme-> {result[0] = result[0] + ((Lexeme)lexeme).isWord();});});
		}
		else if ((text.getChild() !=null) && 
				(text.getChild().get(0).getChild()  !=null) &&
				(text.getChild().get(0).getChild() .get(0).getChild() !=null) &&
				(text.getChild().get(0).getChild().get(0).getChild().get(0) instanceof Lexeme)) {
		
			//text
			text.getChild().forEach(paragraph-> {paragraph.getChild()
				.forEach(sentence-> {sentence.getChild()
				.forEach(lexeme-> {result[0] = result[0] + ((Lexeme)lexeme).isWord();});});});
		}
				 
		return result[0];
	}
	

	public static int sentenceWithWordCount (CompositeText text) {
		
		HashSet<String> result = new HashSet<>();
		
		
		if ((text.getChild() !=null) && 
			(text.getChild().get(0) instanceof Lexeme))  {
			
			//sentence
			text.getChild().forEach(lexeme->{if (((Lexeme)lexeme).isWord() == 1) {result.add("1");} ;});
		} 
		else if ((text.getChild() !=null) && 
				 (text.getChild().get(0).getChild()  !=null) &&
				 (text.getChild().get(0).getChild().get(0) instanceof Lexeme)) {
			
			//paragraph
			text.getChild().forEach(sentence-> {
				sentence.getChild().forEach(lexeme-> {if (((Lexeme)lexeme).isWord() == 1) {result.add(String.valueOf(sentence.getUniqueId()));} ;});});
		}
		else if ((text.getChild() !=null) && 
				(text.getChild().get(0).getChild()  !=null) &&
				(text.getChild().get(0).getChild() .get(0).getChild() !=null) &&
				(text.getChild().get(0).getChild().get(0).getChild().get(0) instanceof Lexeme)) {
		
			//text
			text.getChild().forEach(paragraph-> {paragraph.getChild()
				.forEach(sentence-> {sentence.getChild()
				.forEach(lexeme-> {if (((Lexeme)lexeme).isWord() == 1) {result.add(String.valueOf(sentence.getUniqueId()));} ;});});;});
		}
				 
		return result.size();
	}
	

}
