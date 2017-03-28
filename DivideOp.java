/**
 * This class extends BinaryOp class, represents the divisor operator token
 * 
 *
 */
public class DivideOp extends BinaryOp {

	@Override
	public double operate(double left, double right) {
		return left / right;
	}

	/**
	 * @return the String representation of this kind of operation
	 */
	@Override
	public String toString() {
		return "/";
	}

}
