package mancala;

import java.io.Serializable;

public class PitNotFoundException extends Exception implements Serializable {
    private static final long serialVersionUID = 3730944328514739412L;

    public PitNotFoundException() {
        super("Pit not found.");
    }
    public PitNotFoundException(final String message) {
        super(message);
    }
}
