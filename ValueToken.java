/**
 * This class extends CalcToken class, represents all the number tokens
 * 
 *
 */
public class ValueToken extends CalcToken {

	private double value;

	/**
	 * 
	 * @param value is the value of object's field
	 */
	public ValueToken(double value) {
		this.value = value;
	}

	/**
	 * @return the value of field "value"
	 **/
	public double getValue() {
		return this.value;
	}

	/**
	 * @return the String representation of this kind of token
	 */
	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

}
