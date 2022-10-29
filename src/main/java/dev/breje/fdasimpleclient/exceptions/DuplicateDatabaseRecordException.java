package dev.breje.fdasimpleclient.exceptions;

public class DuplicateDatabaseRecordException extends Exception {

    public DuplicateDatabaseRecordException(String message) {
        super(message);
    }

    public DuplicateDatabaseRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}
