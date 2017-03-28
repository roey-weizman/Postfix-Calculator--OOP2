/**
 * This is a testing framework. Use it extensively to verify that your code is
 * working properly.
 */
public class Tester {

	private static boolean testPassed = true;
	private static int testNum = 0;

	/**
	 * This entry function will test all classes created in this assignment.
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {

		// Each function here should test a different class.
		testValueToken();
		testPostfixCalculator();
		testAddOp();
		testDivideOp();
		testMultiplyOp();
		testSubtractOp();
		testPowOp();
		testCloseBracket();
		testOpenBracket();
		testExpTokenizer();
		/* TODO - write a function for each class */

		// Notifying the user that the code have passed all tests.
		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}

	/**
	 * This utility function will count the number of times it was invoked. In
	 * addition, if a test fails the function will print the error message.
	 * 
	 * @param exp
	 *            The actual test condition
	 * @param msg
	 *            An error message, will be printed to the screen in case the
	 *            test fails.
	 */
	private static void test(boolean exp, String msg) {
		testNum++;

		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: " + msg);
		}
	}

	/**
	 * Checks the ValueToken class.
	 */
	private static void testValueToken() {

		ValueToken t1 = new ValueToken(5.1);
		ValueToken t2 = new ValueToken(-26.3);
		ValueToken t3 = new ValueToken(Math.PI);
		test(t1.getValue() == 5.1, "Value should be 5.1.");
		test(t1.toString().equals("5.1"), "Value toString should be 5.1.");
		test(t2.getValue() == -26.3, "Value should be -26.3.");
		test(t2.toString().equals("-26.3"), "Value toString should be -26.3.");
		test(t3.getValue() == Math.PI, "Value should be PI");
		test(t3.toString().equals("3.141592653589793"), "Value toString should be PI");

		/* TODO add more tests to the ValueToken class! */
	}

	/**
	 * Checks the ExpTokenizer class.
	 */
	private static void testExpTokenizer() {
		ExpTokenizer exp1 = new ExpTokenizer("2 3 +");
		ExpTokenizer exp2 = new ExpTokenizer("2 4 ^ 5 3 + /", true);
		ExpTokenizer exp3 = new ExpTokenizer("2 3 +", false);
		ExpTokenizer exp4 = new ExpTokenizer("");
		String s = new String("2");
		String s1 = new String("+");
		test(exp1.hasMoreElements() == true, "value hasMoreElements should be true");
		test(exp4.hasMoreElements() == true, "value hasMoreElements should be true");
		test(exp1.hasMoreTokens() == true, "value hasMoreTokens should be true");
		test(exp2.countTokens() == 7, "value countTokens should be 7");
		test(exp2.nextToken().equals(s), "value nextTokens should be 2");
		test(exp3.nextToken().equals(s1), "value nextTokens should be +");
		test(exp4.nextToken().equals(""), "value nextTokens should be" + "");
		test(exp1.countTokens() == 3, "value countTokens should be 3");
		test(exp4.countTokens()==0,"value countTokens should be 0");
		test(exp4.hasMoreTokens()==false,"value hasMoreTokens should be false");
		test(exp3.countTokens()==2, "value countTokens should be 2");

		
		
	}

	/**
	 * Checks the CloseBracket class.
	 */
	private static void testCloseBracket() {
		CloseBracket bracket = new CloseBracket();
		test(bracket.toString().equals(")"), "Value toString should be )");
		test(!(bracket.toString().equals("(")), "Value toString should be )");
		

	}

	/**
	 * Checks the OpenBracket class.
	 */
	private static void testOpenBracket() {
		OpenBracket bracket = new OpenBracket();
		test(bracket.toString().equals("("), "Value toString should be (");
		test(!(bracket.toString().equals(")")), "Value toString should be (");
	}

	/**
	 * Checks the SubtractOp class.
	 */
	private static void testSubtractOp() {
		SubtractOp subtractOp1 = new SubtractOp();
		SubtractOp subtractOp2 = new SubtractOp();
		SubtractOp subtractOp3 = new SubtractOp();
		test(subtractOp1.operate(6, 4) == 2, "Result should be 2");
		test(subtractOp2.toString().equals("-"), "Value toString should be -.");
		test(subtractOp3.operate(subtractOp1.operate(6, 4), 10)==-8,"Result should be -8");
	}

	/**
	 * Checks the MultiplyOp class.
	 */
	private static void testMultiplyOp() {
		MultiplyOp multiplyOp1 = new MultiplyOp();
		MultiplyOp multiplyOp2 = new MultiplyOp();
		MultiplyOp multiplyOp3 = new MultiplyOp();
		test(multiplyOp1.operate(6, 4) == 24, "Result should be 24");
		test(multiplyOp2.toString().equals("*"), "Value toString should be *.");
		test(multiplyOp3.operate(multiplyOp3.operate(6, 4), 0.5) == 12, "Result should be 12");
	}

	/**
	 * Checks the PowOp class.
	 */
	private static void testPowOp() {
		PowOp PowOp1 = new PowOp();
		PowOp powOp2 = new PowOp();
		PowOp powOp3 = new PowOp();
		test(PowOp1.operate(2, 3) == 8, "Result should be 8");
		test(powOp2.toString().equals("^"), "Value toString should be ^.");
		test(powOp3.operate(PowOp1.operate(2, 2), (2))==16,"Result should be 16");

	}

	/**
	 * Checks the AddOp class.
	 */
	private static void testAddOp() {
		AddOp addop1 = new AddOp();
		AddOp addop2 = new AddOp();
		AddOp addop3 = new AddOp();
		test(addop1.operate(6, 4) == 10, "Result should be 10");
		test(addop2.toString().equals("+"), "Value toString should be +.");
		test(addop3.operate(addop1.operate(6, 4), 10)==20,"Result should be 20");
	}

	/**
	 * Checks the DivideOp class.
	 */
	private static void testDivideOp() {
		DivideOp divideop1 = new DivideOp();
		DivideOp divideop2 = new DivideOp();
		DivideOp divideop3 = new DivideOp();
		test(divideop1.operate(10, 4) == 2.5, "Result should be 2.5");
		test(divideop2.toString().equals("/"), "Value toString should be /.");
		test(divideop3.operate(divideop1.operate(10, 4), 2.5)==1,"Result should be 1");
	}

	/**
	 * Checks the PostfixCalculator class.
	 */
	private static void testPostfixCalculator() {
		PostfixCalculator c1 = new PostfixCalculator();
		PostfixCalculator c2 = new PostfixCalculator();
		PostfixCalculator c3 = new PostfixCalculator();
		PostfixCalculator c4 = new PostfixCalculator();
		PostfixCalculator c5 = new PostfixCalculator();
		PostfixCalculator c6 = new PostfixCalculator();
		PostfixCalculator c7 = new PostfixCalculator();
		PostfixCalculator c8 = new PostfixCalculator();
		PostfixCalculator c9 = new PostfixCalculator();
		PostfixCalculator c10 = new PostfixCalculator();
		PostfixCalculator c11 = new PostfixCalculator();
		PostfixCalculator c12 = new PostfixCalculator();
		PostfixCalculator c13 = new PostfixCalculator();
		PostfixCalculator c14 = new PostfixCalculator();

		c1.evaluate("2 3 ^ 4 2 * / 7 -");
		c2.evaluate("2 3 ^ 4 2 * / -7 -");
		c3.evaluate("2 5 +");
		c4.evaluate("9 7 -");
		c5.evaluate("3 5 ^");
		c6.evaluate("10 2 /");
		c7.evaluate("3 4 *");
		c8.evaluate("3 5 ^ 2 1 + / ");

		test(c1.getCurrentResult() == -6, "value should be -6.0");
		test(c2.getCurrentResult() == 8, "value should be 8.0");
		test(c3.getCurrentResult() == 7, "value should be 7.0");
		test(c4.getCurrentResult() == 2, "value should be 2.0");
		test(c5.getCurrentResult() == 243, "value should be 243.0");
		test(c6.getCurrentResult() == 5, "value should be 5.0");
		test(c7.getCurrentResult() == 12, "value should be 12.0");
		test(c8.getCurrentResult() == 81, "value should be 81.0");

		try {
			c9.evaluate("2 3");
			test(false, String.format("Excpected a ParseException"));
		} catch (ParseException e) {
			test(c9.getCurrentResult() == 0, "Got Exception");
		}

		try {
			c10.evaluate(" + ");
			test(false, String.format("Excpected a ParseException"));
		} catch (ParseException e) {
			test(c10.getCurrentResult() == 0, "Got Exception");
		}
		try {
			c11.evaluate("2 5 * 7 9 $");
			test(false, "Excpected a ParseException");
		} catch (ParseException e) {
			test(c11.getCurrentResult() != 0, "Got Exception");
		}
		try {
			c12.evaluate("6 5 * 8 9 / 4 2 ^");
			test(false, "Excpected a ParseException");
		} catch (ParseException e) {
			test(c12.getCurrentResult() != 0, "Got Exception");
		}
		try {
			c13.evaluate("7.0.1");
			test(false, "Excpected a ParseException");
		} catch (ParseException e) {
			test(c13.getCurrentResult() == 0, "Got Exception");
		}
		try {
			c14.evaluate(null);
			test(false, "Excpected a RuntimeException");
		} catch (RuntimeException e) {
			test(c14.getCurrentResult() == 0, "Got Exception");
		}
		/*
		 * TODO Go for it! write your tests here for the PostfixCalculator
		 * class!
		 */
	}

}