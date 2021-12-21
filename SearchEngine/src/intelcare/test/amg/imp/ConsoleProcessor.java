package intelcare.test.amg.imp;

import java.util.Scanner;
import intelcare.test.amg.imp.Constants;

public class ConsoleProcessor {
		
	public void processCommandInput() {
		System.out.println(Constants.baseConsoleInputMessage);
		Scanner in =  new Scanner(System.in);
		String line=null;
		do {
			//System.out.println(Constants.baseConsoleInputMessage);
			try {
								line = in.nextLine().trim();
				if (line.length() > 0 && !(line.equals(Constants.baseConsoleLoopExitCommand))) {
					parseLine(line);
					continue;
				} else if  (!line.equals("exit")) {
					System.err.println(Constants.baseConsoleErrorMessage);
				}
			} catch (Exception ex) {
				System.err.println(Constants.baseConsoleErrorMessage);
			}
		} while (!line.equals(Constants.baseConsoleLoopExitCommand));
		in.close();
		System.out.println(Constants.baseConsoleLoopExitMessage);
		return;
	}

	private void parseLine(String line) {
		String[] parsedCommandArray = line.split(" ");
		String command = parsedCommandArray[0];
		if (command.equals("index")) {
			Command cmd = new CommandIndex();
			boolean result = cmd.validate(parsedCommandArray);
			if (result) result = cmd.process(parsedCommandArray);
			return;
		} else if (command.equals("query")) {
			Command cmd = new CommandQuery();
			boolean result = cmd.validate(parsedCommandArray);
			if (result) result = cmd.process(parsedCommandArray);
			return;
		} else {
			System.err.println(Constants.baseConsoleErrorMessage);
		}	
		return;
	}

	
	
}
