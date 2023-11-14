package exceptions;

public class TimeOutException extends Throwable {
    public TimeOutException() {
        super("O timer para achar a partida estourou!");
    }
}
