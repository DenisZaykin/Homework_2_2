package org.zaykin.shop.exception;

/**
 * Created by a on 10.07.2017.
 */
public class InvalidParameterException extends Exception{

    public InvalidParameterException() {
        super();
    }
    public InvalidParameterException(String message) {
        super(message);
    }
    public InvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidParameterException(Throwable cause) {
        super(cause);
    }

}
