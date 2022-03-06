package com.poloniex.exception;

import com.poloniex.PoloniexApiError;

/**
 * An exception which can occur while invoking methods of the Poloniex API.
 */
public class PoloniexApiException extends RuntimeException {

    private static final long serialVersionUID = 2373280079704476969L;

    private PoloniexApiError error;

    public PoloniexApiException(PoloniexApiError error) {
        this.error = error;
    }

    public PoloniexApiException() {
        super();
    }

    public PoloniexApiException(String message) {
        super(message);
    }

    public PoloniexApiException(Throwable cause) {
        super(cause);
    }

    public PoloniexApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Poloniex API,
     * or null if no response object was returned (e.g. server returned 500).
     */
    public PoloniexApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
