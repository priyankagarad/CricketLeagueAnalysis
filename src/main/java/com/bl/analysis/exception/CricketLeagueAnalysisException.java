package com.bl.analysis.exception;
public class CricketLeagueAnalysisException extends RuntimeException {
    public enum ExceptionType {
        FILE_NOT_FOUND,WRONG_DELIMITER_FILE;
    }
    public ExceptionType exceptionTypeObject;

    public CricketLeagueAnalysisException(String message, ExceptionType exceptionTypeObject) {
        super(message);
        this.exceptionTypeObject = exceptionTypeObject;
    }
}
