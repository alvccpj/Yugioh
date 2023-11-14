package exceptions;

public class IrregularDeckException extends Throwable{
    public IrregularDeckException() {
        super("Você inseriu um deck inválido para jogar!");
    }
}
