package exceptions;

public class InsuficientCoinException extends Throwable {
    public InsuficientCoinException() {
        super("Você não possui saldo suificiente para a comprar do booster!");
    }
}
