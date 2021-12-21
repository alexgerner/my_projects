package intelcare.test.amg.imp;

public class Constants {
	public static final String baseConsoleErrorMessage = "..Console Input error.";
	public static final String baseIndexErrorMessage = "..Index error ==> ";
	public static final String baseIndexSuccessMessage = "..Index ok ==> doc-id=";
	public static final String baseConsoleInputMessage = "Please enter the command index doc-id (tokenN) or query expression. Enter 'exit' to exit the program: ";
	public static final String baseConsoleLoopExitCommand = "exit";
	public static final String baseConsoleLoopExitMessage  = "The scanner loop has been ended";
	public static final String docIdIndexErrorMessage = "An input error occurred in tokens of the doc-id=";
	public static final String docIdIndexErrorNotNumericMessage = "An input error occurred ==> doc-id is not numeric.";
	public static final String docIdIndexErrorNegativeMessage = "An input error occurred ==> doc-id can't be negative.";
	public static final String baseQueryResultMessage = "..Query results ==> ";
	public static final String baseQueryResultNoMatchMessage = "No Match";
	public static final String baseQueryErrorMessage = "..Query Expression Input error.";
	public static final String regexpAZ = "[a-zA-Z]+";
	public static final String regexpAZPlusBool = "[a-zA-Z//(//)//&//|]+";

}
