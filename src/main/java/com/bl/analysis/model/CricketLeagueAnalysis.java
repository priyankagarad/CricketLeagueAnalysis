package com.bl.analysis.model;
import com.bl.analysis.builder.CSVBuilderFactory;
import com.bl.analysis.builder.ICSVBuilder;
import com.bl.analysis.exception.CricketLeagueAnalysisException;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class CricketLeagueAnalysis {
    List<CSVRunner> csvFileList = null;

    public Integer loadIPLData(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.icsBuilder();
            csvFileList= csvBuilder.getCSVFileList(reader, CSVRunner.class);
            return csvFileList.size();
        } catch (IOException e) {
            throw new CricketLeagueAnalysisException(e.getMessage(),CricketLeagueAnalysisException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CricketLeagueAnalysisException(e.getMessage(),CricketLeagueAnalysisException.ExceptionType.WRONG_DELIMITER_FILE);
        }
    }

    public String getTopBattingaverage() {
        if (csvFileList.size() == 0 || csvFileList == null)
            throw new CricketLeagueAnalysisException("No Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVRunner> runsComparator = Comparator.comparing(census -> census.getAvg());
        this.sort(runsComparator);
        String sortedCensusJson = new Gson().toJson(csvFileList);
        return sortedCensusJson;
    }

   public String getTopStrickeRate(){
       if(csvFileList.size()==0 || csvFileList==null)
           throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
           Comparator<CSVRunner> runnerComparator=Comparator.comparing(csvRunner -> csvRunner.getSR());
           this.sort(runnerComparator);
           String sortedDataJson=new Gson().toJson(csvFileList);
           return sortedDataJson;
   }

    public String getMaximumSixesInMatch(){
        if(csvFileList.size()==0 || csvFileList==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVRunner> runnerComparator=Comparator.comparing(csvRunner -> csvRunner.getSixs());
        this.sort(runnerComparator);
        String sortedDataJson=new Gson().toJson(csvFileList);
        return sortedDataJson;
    }

    public String getMaximumFoursInMatch(){
        if(csvFileList.size()==0 || csvFileList==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVRunner> runnerComparator=Comparator.comparing(csvRunner -> csvRunner.getFours());
        this.sort(runnerComparator);
        String sortedDataJson=new Gson().toJson(csvFileList);
        return sortedDataJson;
    }

    public String getSortedStrickRateOfFoursAndSixs(){
        if(csvFileList.size()==0 || csvFileList==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVRunner> runnerComparator=Comparator.comparing(csvRunner -> csvRunner.getSR());
        this.sort(runnerComparator);
        String sortedDataJson=new Gson().toJson(csvFileList);
        return sortedDataJson;
    }
    
    private void sort(Comparator<CSVRunner> iplComparator) {
        for (int i = 0; i < csvFileList.size() - 1; i++) {
            for (int j = 0; j < csvFileList.size() - i - 1; j++) {
                CSVRunner census1 = csvFileList.get(j);
                CSVRunner census2 =csvFileList.get(j + 1);
                if (iplComparator.compare(census1, census2) < 0) {
                    csvFileList.set(j, census2);
                    csvFileList.set(j + 1, census1);
                }
            }
        }
    }
}


