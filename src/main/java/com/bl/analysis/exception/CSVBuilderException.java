package com.bl.analysis.exception;
public class CSVBuilderException extends RuntimeException
{
    public enum ExceptionType{
        UNABLE_TO_PARSE
    }
    public CSVBuilderException.ExceptionType type;
    public CSVBuilderException(String message,CSVBuilderException.ExceptionType type) {
        super(message);
        this.type = type;
    }
}


