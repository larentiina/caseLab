package org.test.caselab.exception;

public class InvalidFileDataException extends RuntimeException{
    public InvalidFileDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
