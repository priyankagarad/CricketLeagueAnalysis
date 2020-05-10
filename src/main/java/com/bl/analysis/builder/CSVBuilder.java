package com.bl.analysis.builder;
import com.bl.analysis.exception.CSVBuilderException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.util.List;
class CSVBuilder implements ICSVBuilder
{
    @Override
    public List<ICSVBuilder> getCSVFileList(BufferedReader reader, Class csvClass)  {
        return this.getCSVToBean(reader, csvClass).parse();
    }

    private CsvToBean getCSVToBean(BufferedReader reader, Class csvClass) {
        try {
            CsvToBeanBuilder<ICSVBuilder> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<ICSVBuilder> csvToBean = csvToBeanBuilder.build();
            return csvToBean;
        } catch (IllegalStateException e) {
            throw new CSVBuilderException(e.getMessage(),
                    CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
}