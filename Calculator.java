/**
 * Abstract "superclass" describing ALL types of calculators
 */
public abstract class Calculator {
	public double currentresult;

	public Calculator() {
		currentresult = 0;
	}

	public abstract void evaluate(String expr);

	/**
	 * @return the result of field currentresult that method "evaluate"
	 *         computes/
	 */
	public double getCurrentResult() {

		return currentresult;
	}
}
