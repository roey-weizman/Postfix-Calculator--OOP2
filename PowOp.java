
public class PowOp extends BinaryOp {

	public double operate(double left, double right) {
		return Math.pow(left, right);
	}

	/**
	 * @return the String representation of this kind of operation
	 */
	public String toString() {
		return "^";
	}
}
