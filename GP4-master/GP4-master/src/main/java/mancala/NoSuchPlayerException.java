package mancala;

import java.io.Serializable;

public class NoSuchPlayerException extends Exception implements Serializable{

    private static final long serialVersionUID = -8164832736926195625L;
    public NoSuchPlayerException() {
    
        super("This player does not exist.");
    }
    public NoSuchPlayerException(final String message) {
        super(message);
    }
}
