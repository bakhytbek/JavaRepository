package by.epam.tr.text;

import java.util.Arrays;
import java.util.List;

import by.epam.tr.constant.Setting;

public class Lexeme implements ComponentText {

	private String prefix;
	private String word;
	private String postfix;
	
	private int uniqueId;
	
	public Lexeme() {
		this.prefix = "";
		this.word = "";
		this.postfix = "";
		this.uniqueId = Setting.getUniqueId();
	}
	
	@Override
	public String toString() {
		return prefix + word + postfix;
	}
	
	@Override
	public List<ComponentText> getChild() {
		return Arrays.asList(this);
	}
	
	@Override
	public int getUniqueId() {
		return uniqueId;
	}

	
	public int isWord() {
		if (this.word.isEmpty()) {
			return 0;
		} else return 1;
	}

	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
	public void appendPrefix(String prefix) {
		this.prefix = this.prefix + prefix;	
	}
	
	public void appendPostfix(String postfix) {
		this.postfix = this.postfix + postfix;	
	}


	public String getPrefix() {
		return this.prefix;	
	}
	
	public String getPostfix() {
		return this.postfix;	
	}

}
