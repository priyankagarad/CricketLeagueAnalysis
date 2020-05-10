package com.analysis;
import com.bl.analysis.model.CSVRunner;
import com.bl.analysis.model.CSVWkts;
import com.bl.analysis.model.CricketLeagueAnalysis;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.bl.analysis.model.FileUtility.*;
public class CricketLeagueAnalysisTest
{
    CricketLeagueAnalysis cricketLeagueAnalysis;
    @Before
    public void setUP()
    {
        cricketLeagueAnalysis = new CricketLeagueAnalysis();
    }

    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnPlayerWithBestBattingAverage() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getTopBattingaverageWithSR();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName=batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("MS Dhoni",playerName);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnBestStrickRate() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getTopStrickeRate();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("Ishant Sharma", playerName);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnFoursWise() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getMaximumFoursInMatch();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("Shikhar Dhawan", playerName);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSixs() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getMaximumSixesInMatch();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("Andre Russell", playerName);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnFourAndSix() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedStrickRateOfFoursAndSixs();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("Ishant Sharma", playerName);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnSortedRunWithBestAverage() {
        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedRunsWithBestAvrage();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("Yuvraj Singh", playerName);
    }

    @Test
    public void givenCricketLeagueData_whenNumberOfRecordMatches_shouldReturnTrue() {
            int numberOfRecords = cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
            Assert.assertEquals(99, numberOfRecords);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnWktsAverage() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedWktsAvrageData();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        double runs=csvWkts[0].getAvg();
        Assert.assertEquals("Krishnappa Gowtham",playerName);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnWktsTopStrickRate() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDataOfWicketsWithBestStrikingRate();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Krishnappa Gowtham",playerName);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestEconomy() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDataAccordingToBestEconomy();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Ben Cutting",playerName);
    }
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestStrickRate4W() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDataAccordingToBestStrickRateOf4w();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Imran Tahir",playerName);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestStrickRate5W() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDataAccordingToBestStrickRateOf5w();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Alzarri Joseph",playerName);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestStrickRateWithAverage() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedWktsAvrageData();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Krishnappa Gowtham",playerName);
    }
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestWkts() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDataAccordingToBestWickets();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Imran Tahir",playerName);
    }
    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnBestBowlingAndBestBattingAverage() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedWktsAvrageData();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName = csvWkts[0].getPLAYER();
        Assert.assertEquals("Krishnappa Gowtham", playerName);

        cricketLeagueAnalysis.loadIPLDataOfRuns(BATSMAN_CSV_FILE_PATH);
        String sorteddata1 = cricketLeagueAnalysis.getTopBattingaverageWithSR();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata1, CSVRunner[].class);
        String playerName1 = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("MS Dhoni", playerName1);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_ShouldReturnAllRounderWithRunsAndWkts() {
        cricketLeagueAnalysis.loadIPLDataOfWkts(WICKETS_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getSortedDataAccordingToBestRuns();
        CSVWkts[] csvWkts = new Gson().fromJson(sorteddata, CSVWkts[].class);
        String playerName=csvWkts[0].getPLAYER();
        Assert.assertEquals("Deepak Chahar",playerName);
    }
}

