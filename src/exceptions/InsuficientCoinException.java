package exceptions;

public class InsuficientCoinException extends Throwable {
    public InsuficientCoinException(String message) {
        super(message);
    }
}
