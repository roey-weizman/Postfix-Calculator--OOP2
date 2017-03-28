/**
 * This class extends RuntimeException class , represents all kind of errors
 * causing by parse and syntax mistakes
 * 
 *
 */
public class ParseException extends RuntimeException {
	public String synError;

	public ParseException(String message) {
		synError = message;
	}

	public String getMessage() {
		return synError;
	}

}
