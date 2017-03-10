package by.epam.tr.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.epam.tr.constant.Setting;

public class CompositeText implements ComponentText {

	private ArrayList<ComponentText> childText = new ArrayList<>();
	private int uniqueId;

	@Override
	public List<ComponentText> getChild() {
		return Collections.unmodifiableList(childText);
	}

	@Override
	public String toString() {

		StringBuilder result = new StringBuilder();

		for (ComponentText child: childText) {
			result.append(child.toString());
		}
		
		return result.toString();
		
	}
	
	@Override
	public int getUniqueId() {
		return uniqueId;
	}
	
	public CompositeText() {
		uniqueId = Setting.getUniqueId();
	}
	
	public void add(ComponentText componentText) {
		childText.add(componentText);
	}
	
	public void remove(ComponentText componentText) {
		childText.remove(componentText);
	}
	

	
}
