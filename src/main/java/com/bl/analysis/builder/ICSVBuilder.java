package com.bl.analysis.builder;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.List;
public interface ICSVBuilder<E>
{
    public List<E> getCSVFileList(BufferedReader reader, Class csvClass);
}