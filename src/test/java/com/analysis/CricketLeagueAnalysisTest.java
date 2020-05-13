package com.analysis;
import com.bl.analysis.exception.CricketLeagueAnalysisException;
import com.bl.analysis.model.CSVRunner;
import com.bl.analysis.model.CSVWkts;
import com.bl.analysis.CricketLeagueAnalysis;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class CricketLeagueAnalysisTest
{
    CricketLeagueAnalysis cricketLeagueAnalysis;
    public static final String BATSMAN_CSV_FILE_PATH="./src/test/resources/MostRuns.csv";
    public static final String WICKETS_CSV_FILE_PATH="./src/test/resources/MostWkts.csv";

    @Before
    public void setUP()
    {
        cricketLeagueAnalysis = new CricketLeagueAnalysis();
    }

    //TC:1.1
    @Test
    public void givenCsvFile_whenNumberOfRecordMatches_thenReturnTrue() throws CricketLeagueAnalysisException {
        try {
            int numberOfRecords = cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
            Assert.assertEquals(100, numberOfRecords);
        } catch (CricketLeagueAnalysisException e) {
        }
    }

    //TC:1.2
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnPlayerWithBestBattingAverage() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getTopBattingaverage();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName=batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("MS Dhoni",playerName);
    }

    //TC:2
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnBestStrickRate() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getTopStrickeRate();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("Ishant Sharma", playerName);
    }

    //TC:3
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnFoursAndSix() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedStrickRateOfFoursAndSixs();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("Andre Russell", playerName);
    }

    //TC:4
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnStrickrRateWithFourAndSix() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedStrickRateOfFoursAndSixs();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("Andre Russell", playerName);
    }

    //TC:5
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnBestAverageWithStrickRate() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getTopBattingaverageWithStrickRate();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("David Warner", playerName);
    }

    //TC:6
    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedRunWithBestAverage() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedRunsWithBestAvrage();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("David Warner", playerName);
    }

    //TC:7.1
    @Test
    public void givenCricketLeagueData_whenNumberOfRecordMatches_shouldReturnTrue() {
        try {
            int numberOfRecords = cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
            Assert.assertEquals(99, numberOfRecords);
        } catch (CricketLeagueAnalysisException e) {
        }
    }

    //TC:7.2
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnWktsAverage() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedWktsWithBestBowllingAvrage();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        double runs=csvWkts[0].getAvg();
        Assert.assertEquals("Anukul Roy",playerName);
    }

    //TC:8
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnWktsTopStrickRate() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDataOfWicketsWithBestStrikingRate();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Alzarri Joseph",playerName);
    }

    //TC:9
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestEconomy() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDataAccordingToBestEconomy();
        System.out.println(sorteddata);
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Shivam Dube",playerName);
    }

    //TC:10
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestStrickRate4Wand5W() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDataAccordingToBestStrickRateOf4wAnd5W();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Shivam Dube",playerName);
    }

    //TC:11
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestBowlingAverageWithBestStrickRate() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDatawithbestBowlingAverageWithBestSR();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Anukul Roy",playerName);
    }

    //TC:12
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestWkts() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDataBowlingMaximumWicketsWithBestBowlingAverage();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Anukul Roy",playerName);
    }

   //TC:13
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestBowlingAndBestBattingAverage() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDatawithbestBowlingAveragWithBestBattingAverage();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName = csvWkts[0].getPLAYER();
        Assert.assertEquals("Suresh Raina", playerName);
    }

    //TC:14
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestRuner() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDataforAllRounder();
        System.out.println(sorteddata);
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[98].getPLAYER();
        Assert.assertEquals("Deepak Chahar",playerName);
    }
}
