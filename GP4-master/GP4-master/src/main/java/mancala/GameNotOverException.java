package mancala;

import java.io.Serializable;

public class GameNotOverException extends Exception implements Serializable {
    private static final long serialVersionUID = 8972329373994338189L;

    public GameNotOverException() {
        super("Game is not over.");
    }

    
    public GameNotOverException(final String message) {
        super(message);
    }
}
