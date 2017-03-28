/**
 * This class extends the calculator class, class's main object is a postfix
 * calculator which calculates postfix expression
 *
 */

public class PostfixCalculator extends Calculator {

	/**
	 * method that helps us compute postfix expressions using stack * @param exp
	 * is expression that should be compute by the calculator
	 */

	public void evaluate(String exp) throws ParseException {
		if (hasOp(exp) == false)
			throw new ParseException("SYNTAX ERROR: NO OPERATOR GIVEN");
		if (hasNum(exp) == false)
			throw new ParseException("SYNTAX ERROR: NO NUMBERS GIVEN");
		ExpTokenizer helper = new ExpTokenizer(exp);
		StackAsArray array = new StackAsArray();
		double op1;
		double op2;
		int count = helper.countTokens();
		for (int i = 1; i <= count; i = i + 1) {
			CalcToken general = (CalcToken) helper.nextElement();
			if (general instanceof ValueToken)
				array.push(general);
			else if (general instanceof BinaryOp) {
				if (array.isEmpty())
					throw new ParseException("SYNTAX ERROR: INVALID EXPRESSION");
				op2 = ((ValueToken) array.pop()).getValue();
				op1 = ((ValueToken) array.pop()).getValue();
				array.push(new ValueToken(((BinaryOp) general).operate(op1, op2)));

			}
		}

		try {
			super.currentresult = ((ValueToken) array.pop()).getValue();
		} catch (Exception e) {
			System.out.println("SYNTAX ERROR: CAN'T CALCULATE EXPRESSION");
		}
		if (array.isEmpty() == false)
			throw new ParseException("SYNTAX ERROR: INCORRECT INPUT");
	}

	/**
	 * * @param exp is a postfix expression * @return boolean variable if exp
	 * contains operator
	 */
	public static boolean hasOp(String exp) {
		boolean ans = false;
		for (int j = 0; j < exp.length() && ans == false; j++) {
			if (exp.charAt(j) == '+' || exp.charAt(j) == '*' || exp.charAt(j) == '/' || exp.charAt(j) == '^'
					|| exp.charAt(j) == '-')
				ans = true;
		}
		return ans;
	}

	/**
	 * * @param exp is a postfix expression * @return boolean variable if exp
	 * contains number
	 */
	public static boolean hasNum(String exp) {
		boolean ans = false;
		for (int k = 0; k < exp.length() && ans == false; k++) {
			if (exp.charAt(k) >= '0' && exp.charAt(k) <= '9')
				ans = true;
		}
		return ans;
	}
}
