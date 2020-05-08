package com.bl.analysis.model;
import com.bl.analysis.exception.CricketLeagueAnalysisException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
public class CricketLeagueAnalysis {
    public int LoadIPLData(String filePath)
    {
        int count = 0;
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            CsvToBean<IPLMostRun> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(IPLMostRun.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IPLMostRun> analyser = csvToBean.iterator();
            while (analyser.hasNext()) {
                IPLMostRun iplMostRuns = analyser.next();
                count++;
            }
        } catch (IOException e) {
            throw new CricketLeagueAnalysisException(e.getMessage(), CricketLeagueAnalysisException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CricketLeagueAnalysisException(e.getMessage(), CricketLeagueAnalysisException.ExceptionType.INCORRECT_FILE);
        }
        return count;
    }
}

