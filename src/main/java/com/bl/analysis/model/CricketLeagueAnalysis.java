package com.bl.analysis.model;
import com.bl.analysis.exception.CricketLeagueAnalysisException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Iterator;
import static java.nio.file.Files.newBufferedReader;
public class CricketLeagueAnalysis {
   public int loadIPLData( String filePath)
   {
       int totalRecords = 0;
       try (Reader reader = newBufferedReader(Paths.get(filePath));)
       {
           CsvToBean<IPLMostRun> csvStateCensusBeanObj = new CsvToBeanBuilder(reader)
                   .withType(IPLMostRun.class)
                   .withIgnoreLeadingWhiteSpace(true)
                   .build();
           Iterator<IPLMostRun> csvStateCensusIterator = csvStateCensusBeanObj.iterator();
           while (csvStateCensusIterator.hasNext()) {
               IPLMostRun csvStateCensus = csvStateCensusIterator.next();
               totalRecords++;
           }
       }
       catch (IOException e)
       {
           throw new CricketLeagueAnalysisException(e.getMessage(),CricketLeagueAnalysisException.ExceptionType.FILE_NOT_FOUND);
       }
       catch (RuntimeException e)
       {
           throw new CricketLeagueAnalysisException(e.getMessage(),CricketLeagueAnalysisException.ExceptionType.WRONG_DELIMITER_FILE);
       }
       return totalRecords;
   }
}


