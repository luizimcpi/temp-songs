package com.devlhse.tempsongs.exception;

public class TrackNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TrackNotFoundException() {
        super();
    }
    public TrackNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public TrackNotFoundException(String message) {
        super(message);
    }
    public TrackNotFoundException(Throwable cause) {
        super(cause);
    }
}
