package intelcare.test.amg.junit.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Test;

import intelcare.test.amg.imp.ConsoleProcessor;
import intelcare.test.amg.imp.Constants;

public class ConsoleProcessorTest {
	
	@Test
	public void test1() {
	
		String line = null;
		System.out.println(Constants.baseConsoleInputMessage);
		Scanner	in = new Scanner(System.in);
		line = in.nextLine();
		assertNotNull(line);
		in.close();		
	
	}


}
