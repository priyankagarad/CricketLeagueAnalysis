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
    List<CSVWkts> csvFileListOfWkts= null;

    public Integer loadIPLDataOfRuns(String filePath) {
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

    public Integer loadIPLDataOfWkts(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.icsBuilder();
            csvFileListOfWkts= csvBuilder.getCSVFileList(reader, CSVWkts.class);
            return csvFileListOfWkts.size();
        } catch (IOException e) {
            throw new CricketLeagueAnalysisException(e.getMessage(),CricketLeagueAnalysisException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CricketLeagueAnalysisException(e.getMessage(),CricketLeagueAnalysisException.ExceptionType.WRONG_DELIMITER_FILE);
        }
    }

    public String getTopBattingaverageWithSR() {
        if (csvFileList.size() == 0 || csvFileList == null)
            throw new CricketLeagueAnalysisException("No Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVRunner> runsComparator = Comparator.comparing(census -> census.getAvg());
        this.sortedDataOfRuns(runsComparator);
        String sortedCensusJson = new Gson().toJson(csvFileList);
        return sortedCensusJson;
    }

    public String getTopStrickeRate(){
        if(csvFileList.size()==0 || csvFileList==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVRunner> runnerComparator=Comparator.comparing(csvRunner -> csvRunner.getSR());
        this.sortedDataOfRuns(runnerComparator);
        String sortedDataJson=new Gson().toJson(csvFileList);
        return sortedDataJson;
    }

    public String getMaximumSixesInMatch(){
        if(csvFileList.size()==0 || csvFileList==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVRunner> runnerComparator=Comparator.comparing(csvRunner -> csvRunner.getSixs());
        this.sortedDataOfRuns(runnerComparator);
        String sortedDataJson=new Gson().toJson(csvFileList);
        return sortedDataJson;
    }

    public String getMaximumFoursInMatch(){
        if(csvFileList.size()==0 || csvFileList==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVRunner> runnerComparator=Comparator.comparing(csvRunner -> csvRunner.getFours());
        this.sortedDataOfRuns(runnerComparator);
        String sortedDataJson=new Gson().toJson(csvFileList);
        return sortedDataJson;
    }

    public String getSortedStrickRateOfFoursAndSixs(){
        if(csvFileList.size()==0 || csvFileList==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVRunner> runnerComparator=Comparator.comparing(csvRunner -> csvRunner.getSR());
        this.sortedDataOfRuns(runnerComparator);
        String sortedDataJson=new Gson().toJson(csvFileList);
        return sortedDataJson;
    }
    public String getSortedRunsWithBestAvrage() {
        if(csvFileList.size()==0 || csvFileList==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVRunner> runnerComparator=Comparator.comparing(csvRunner -> csvRunner.getRuns());
        this.sortedDataOfRuns(runnerComparator);
        String sortedDataJson=new Gson().toJson(csvFileList);
        return sortedDataJson;
    }

    public String getSortedWktsAvrageData() {
        if(csvFileListOfWkts.size()==0 || csvFileListOfWkts==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVWkts> iplComparator=Comparator.comparing(csvWkts -> csvWkts.getAvg());
        this.sortedDataOfWkts(iplComparator);
        String sortedDataOfWkts=new Gson().toJson(csvFileListOfWkts);
        return sortedDataOfWkts;
    }

    public String getSortedDataOfWicketsWithBestStrikingRate() {
        if(csvFileListOfWkts.size()==0 || csvFileListOfWkts==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVWkts> iplComparator=Comparator.comparing(csvWkts -> csvWkts.getSR());
        this.sortedDataOfWkts(iplComparator);
        String sortedDataOfWkts=new Gson().toJson(csvFileListOfWkts);
        return sortedDataOfWkts;
    }

    public String getSortedDataAccordingToBestEconomy() {
        if(csvFileListOfWkts.size()==0 || csvFileListOfWkts==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVWkts> iplComparator=Comparator.comparing(csvWkts -> csvWkts.getEcon());
        this.sortedDataOfWkts(iplComparator);
        String sortedDataOfWkts=new Gson().toJson(csvFileListOfWkts);
        return sortedDataOfWkts;
    }
    public String getSortedDataAccordingToBestStrickRateOf4w() {
        if(csvFileListOfWkts.size()==0 || csvFileListOfWkts==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVWkts> iplComparator=Comparator.comparing(csvWkts -> csvWkts.getFourWickets());
        this.sortedDataOfWkts(iplComparator);
        String sortedDataOfWkts=new Gson().toJson(csvFileListOfWkts);
        return sortedDataOfWkts;
    }
    public String getSortedDataAccordingToBestStrickRateOf5w() {
        if(csvFileListOfWkts.size()==0 || csvFileListOfWkts==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVWkts> iplComparator=Comparator.comparing(csvWkts -> csvWkts.getFiveWickets());
        this.sortedDataOfWkts(iplComparator);
        String sortedDataOfWkts=new Gson().toJson(csvFileListOfWkts);
        return sortedDataOfWkts;
    }
    public String getSortedDataAccordingToBestWickets() {
        if(csvFileListOfWkts.size()==0 || csvFileListOfWkts==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVWkts> iplComparator=Comparator.comparing(csvWkts -> csvWkts.getWkts());
        this.sortedDataOfWkts(iplComparator);
        String sortedDataOfWkts=new Gson().toJson(csvFileListOfWkts);
        return sortedDataOfWkts;
    }

    public String getSortedDataAccordingToBestRuns() {
        if(csvFileListOfWkts.size()==0 || csvFileListOfWkts==null)
            throw new CricketLeagueAnalysisException("NO Data",CricketLeagueAnalysisException.ExceptionType.NO_CENSUS_DATA);
        Comparator<CSVWkts> iplComparator=Comparator.comparing(csvWkts -> csvWkts.getRuns());
        this.sortedDataOfWkts(iplComparator);
        String sortedDataOfWkts=new Gson().toJson(csvFileListOfWkts);
        return sortedDataOfWkts;
    }

    private void sortedDataOfRuns(Comparator<CSVRunner> iplComparator) {
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
    private void sortedDataOfWkts(Comparator<CSVWkts> iplComparator1) {
        for (int i = 0; i < csvFileListOfWkts.size() - 1; i++) {
            for (int j = 0; j < csvFileListOfWkts.size() - i - 1; j++) {
                CSVWkts census1 = csvFileListOfWkts.get(j);
                CSVWkts census2 =csvFileListOfWkts.get(j + 1);
                if (iplComparator1.compare(census1, census2) < 0) {
                    csvFileListOfWkts.set(j, census2);
                    csvFileListOfWkts.set(j + 1, census1);
                }
            }
        }
    }
}
