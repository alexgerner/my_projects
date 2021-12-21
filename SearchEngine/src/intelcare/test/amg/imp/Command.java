package intelcare.test.amg.imp;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public interface Command {
	public static LinkedHashMap<String,LinkedList<String>> linkedIndexMap = new LinkedHashMap<String,LinkedList<String>>();
	public boolean validate(String[] commandArray);
	public boolean process(String[] commandArray);

}
