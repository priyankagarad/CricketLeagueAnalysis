package com.bl.analysis.exception;
public class CricketLeagueAnalysisException extends RuntimeException {
    public enum ExceptionType {
        FILE_NOT_FOUND, WRONG_DELIMITER_FILE, NO_CENSUS_DATA, UNABLE_TO_PARSE;
    }
    public ExceptionType exceptionTypeObject;
    public CricketLeagueAnalysisException(String message, ExceptionType exceptionTypeObject) {
        super(message);
        this.exceptionTypeObject = exceptionTypeObject;
    }
}