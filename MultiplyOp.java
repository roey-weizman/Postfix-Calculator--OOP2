/**
 * This class extends CalcToken class, represents the multiplication operator
 * token
 * 
 *
 */
public class MultiplyOp extends BinaryOp {

	@Override
	public double operate(double left, double right) {
		return left * right;
	}

	/**
	 * @return the String representation of this kind of operation
	 */
	@Override
	public String toString() {
		return "*";
	}

}
