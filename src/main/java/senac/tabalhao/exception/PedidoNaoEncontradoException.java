package senac.tabalhao.exception;

import java.util.NoSuchElementException;

public class PedidoNaoEncontradoException extends NoSuchElementException {

    public PedidoNaoEncontradoException(String message) {
        super(message);
    }
}
