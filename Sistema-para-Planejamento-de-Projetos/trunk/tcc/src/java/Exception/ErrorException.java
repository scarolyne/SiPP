package Exception;

/**
 *
 * @author ricobonfim
 */
public class ErrorException extends Exception {

    public ErrorException() {
        super("Houve um erro no processamento de dados.");
    }

    public ErrorException(String mensagem) {
        super(mensagem);
    }
}
