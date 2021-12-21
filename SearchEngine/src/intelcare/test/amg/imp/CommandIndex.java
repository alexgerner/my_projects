package intelcare.test.amg.imp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class CommandIndex implements Command {

	@Override
	public boolean validate(String[] commandArray) {
	    // method validates Console Index Command input 
		int docId;
		boolean result = false;
		try {
			docId = Integer.parseInt(commandArray[1]);
		} catch (NumberFormatException e) {
			System.err.println(Constants.baseIndexErrorMessage+ Constants.docIdIndexErrorNotNumericMessage);
			return false;
		}
		if (docId < 0) {
			System.err.println(Constants.baseIndexErrorMessage+ Constants.docIdIndexErrorNegativeMessage);
			return false;
		}
		String tokens[] = Arrays.copyOfRange(commandArray, 2, commandArray.length);
		String joinedString = Arrays
			    .stream(tokens)
			    .collect(Collectors.joining());
		if (joinedString.matches(Constants.regexpAZ)) {
			System.out.println(Constants.baseIndexSuccessMessage + docId);
			result = true;
		} else	{
			System.err.println(Constants.baseIndexErrorMessage + Constants.docIdIndexErrorMessage + docId);
			result = false;
		}
		return result;
	};
	
	@Override
	public boolean process(String[] commandArray) {
	    // method accumulates successfull Index Commands in global LinkedIndexMap to be parsed by Query Command process implementation 
		String tokens[] = Arrays.copyOfRange(commandArray, 2, commandArray.length);
		LinkedList<String> tokensList = new LinkedList<String>(Arrays.asList(tokens));
		linkedIndexMap.put(commandArray[1], tokensList);
		return true;
	}
}
