package com.bl.analysis.builder;
public class CSVBuilderFactory
{
    public static ICSVBuilder icsBuilder() {
        return new CSVBuilder();
    }
}