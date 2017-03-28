/**
 * This class extends BinaryOp class, represents all the number tokens
 * 
 *
 */
public class AddOp extends BinaryOp {

	@Override
	public double operate(double left, double right) {
		return left + right;
	}

	/**
	 * @return the String representation of this kind of operation
	 */
	@Override
	public String toString() {
		return "+";
	}

}
