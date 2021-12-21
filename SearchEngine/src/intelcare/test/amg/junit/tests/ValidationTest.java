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

public class ValidationTest {

	@Test
	public void test1() {

		int docId = 0;
		boolean result = true;
		try {
			docId = Integer.parseInt("abc");

		} catch (NumberFormatException e) {
			System.err.println(Constants.baseIndexErrorMessage + Constants.docIdIndexErrorNotNumericMessage);
			result = false;
		}
		if (docId < 0) {
			System.err.println(Constants.baseIndexErrorMessage + Constants.docIdIndexErrorNegativeMessage);
			result = false;
		}
		assertFalse(result == true);
	}

	@Test
	public void test2() {

		int docId = 0;
		boolean result = true;
		try {
			docId = Integer.parseInt("-12");

		} catch (NumberFormatException e) {
			System.err.println(Constants.baseIndexErrorMessage + Constants.docIdIndexErrorNotNumericMessage);
			result = false;
		}
		if (docId < 0) {
			System.err.println(Constants.baseIndexErrorMessage + Constants.docIdIndexErrorNegativeMessage);
			result = false;
		}
		assertFalse(result == true);

	}
	@Test
	public void test3() {

		int docId = 0;
		boolean result = true;
		try {
			docId = Integer.parseInt("5");

		} catch (NumberFormatException e) {
			System.err.println(Constants.baseIndexErrorMessage + Constants.docIdIndexErrorNotNumericMessage);
			result = false;
		}
		if (docId < 0) {
			System.err.println(Constants.baseIndexErrorMessage + Constants.docIdIndexErrorNegativeMessage);
			result = false;
		}
		assertTrue(result == true);

	}
}
