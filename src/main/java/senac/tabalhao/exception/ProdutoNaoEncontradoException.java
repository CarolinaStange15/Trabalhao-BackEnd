package senac.tabalhao.exception;

import java.util.NoSuchElementException;

public class ProdutoNaoEncontradoException extends NoSuchElementException {

    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }
}
