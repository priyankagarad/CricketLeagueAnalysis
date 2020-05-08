package com.bl.analysis.exception;
public class CricketLeagueAnalysisException extends RuntimeException {
    public enum ExceptionType {
        FILE_NOT_FOUND, INCORRECT_FILE, NO_CENSUS_DATA;
    }
    public ExceptionType exceptionTypeObject;

    public CricketLeagueAnalysisException(String message, ExceptionType exceptionTypeObject) {
        super(message);
        this.exceptionTypeObject = exceptionTypeObject;
    }
}
