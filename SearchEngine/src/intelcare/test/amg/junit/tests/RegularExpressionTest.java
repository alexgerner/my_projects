package intelcare.test.amg.junit.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;

import intelcare.test.amg.imp.ConsoleProcessor;
import intelcare.test.amg.imp.Constants;

public class RegularExpressionTest {

	@Test
	public void test1() {

		String line = "abcABChhh";
		assert (line.matches(Constants.regexpAZ));

	}

	@Test
	public void test2() {

		String line = "abcABChhh1";
		assertFalse(line.matches(Constants.regexpAZ));

	}

	@Test
	public void test3() {

		String line = "abcABChhh(";
		assertFalse(line.matches(Constants.regexpAZ));

	}

	@Test
	public void test4() {

		String line = "abcABChhh()|&";
		assertTrue(line.matches(Constants.regexpAZPlusBool));

	}

	@Test
	public void test5() {	
		String exp = "query (butter | potato) & salt";
		String[] commandArray = exp.split(" ");
		String[] tokens = Arrays.copyOfRange( commandArray, 1, commandArray.length);
		exp = Arrays.stream(tokens).collect(Collectors.joining());
		exp=exp.replace("|","||");
		if (exp.contains("&")) {
			String[] tokensExp = exp.split("&");
			StringBuffer sb = new StringBuffer();
			Arrays.stream(tokensExp).forEach(token -> {
				sb.append("(" + token + ")");
			});
			exp=sb.toString();
		}
		System.out.println(exp);
		assertTrue(exp.equals("((butter||potato))(salt)"));
	}
}
