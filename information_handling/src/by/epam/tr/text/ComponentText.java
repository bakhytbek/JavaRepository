package by.epam.tr.text;
import java.util.List;

public interface ComponentText {

	public String toString();

	public List<ComponentText> getChild();
	
	public int getUniqueId();
	
}
