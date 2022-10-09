package exception;

public class SaldoInsuficienteException extends Exception {
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String message) {
        super(message);
    }

    public SaldoInsuficienteException(String message, Throwable cause) {
        super(message, cause);
    }
}
