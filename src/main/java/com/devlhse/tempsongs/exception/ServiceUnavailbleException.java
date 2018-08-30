package com.devlhse.tempsongs.exception;

public class ServiceUnavailbleException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceUnavailbleException() {
        super();
    }
    public ServiceUnavailbleException(String message, Throwable cause) {
        super(message, cause);
    }
    public ServiceUnavailbleException(String message) {
        super(message);
    }
    public ServiceUnavailbleException(Throwable cause) {
        super(cause);
    }
}
