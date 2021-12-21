package intelcare.test.amg.imp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.regex.Matcher;

public class CommandQuery implements Command {

	@Override
	public boolean validate(String[] commandArray) {
		String exp = commandArray[1];
		boolean result = false;
		if (exp.matches(Constants.regexpAZPlusBool)) {
			result = true;
		} else {
			System.err.println(Constants.baseQueryErrorMessage);
		}
		return result;
	}

	@Override
	public boolean process(String[] commandArray) {
		String exp = patternExp(commandArray);
		Pattern pattern = Pattern.compile(exp);
		LinkedList<String> matchedDocIds = new LinkedList<String>();
		for (String docId : linkedIndexMap.keySet()) {
			LinkedList<String> tokensList = linkedIndexMap.get(docId);
			Matcher matcher = pattern.matcher(tokensList.toString());
			if (matcher.find()) { matchedDocIds.add(docId); }
		}
		if (matchedDocIds.size() > 0) {
			StringBuffer sb = new StringBuffer();
			matchedDocIds.forEach(docId -> {
				sb.append(docId + " ");
			});
			System.out.println(Constants.baseQueryResultMessage + sb.toString());
		} else {
			System.out.println(Constants.baseQueryResultMessage + Constants.baseQueryResultNoMatchMessage);
		}
		return true;
	}
    private String patternExp(String[] commandArray) {
    	String[] tokens = Arrays.copyOfRange(commandArray, 1, commandArray.length);
		String exp = Arrays.stream(tokens).collect(Collectors.joining());
		exp=exp.replace("|","||");
		if (exp.contains("&")) {
			String[] tokensExp = exp.split("&");
			StringBuffer sb = new StringBuffer();
			Arrays.stream(tokensExp).forEach(token -> {
				sb.append("(" + token + ")");
			});
			exp=sb.toString();
		} 
		return exp;
    }
}
