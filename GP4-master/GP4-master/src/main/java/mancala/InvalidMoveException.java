package mancala;

import java.io.Serializable;

public class InvalidMoveException extends Exception implements Serializable {
    private static final long serialVersionUID = 6985573655049564050L;

    public InvalidMoveException() {
        super("This is a invalid move.");
    }

     
    public InvalidMoveException(final String message) {
        super(message);
    }
}
