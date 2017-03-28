/**
 * This class extends BinaryOp class, represents subtract operator token
 * 
 *
 */
public class SubtractOp extends BinaryOp {

	@Override
	public double operate(double left, double right) {
		return (left) - (right);
	}

	/**
	 * @return the String representation of this kind of operation
	 */
	@Override
	public String toString() {
		return "-";
	}

}
