package com.analysis;
import com.bl.analysis.exception.CricketLeagueAnalysisException;
import com.bl.analysis.model.CSVRunner;
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
    public void givenCsvFile_whenNumberOfRecordMatches_thenReturnTrue() throws CricketLeagueAnalysisException {
        try {
            int numberOfRecords = cricketLeagueAnalysis.loadIPLData(IPL_RUN_SHEET);
             Assert.assertEquals(100, numberOfRecords);
        } catch (CricketLeagueAnalysisException e) {
        }
    }

    @Test
    public void givenIPLCsvFile_WhenWithWrongFile_ThenShouldThrowException()
    {
        try {
            cricketLeagueAnalysis.loadIPLData(WRONG_CSV_FILE_Name);
        } catch ( CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.FILE_NOT_FOUND,e.exceptionTypeObject);
        }
    }

    @Test
    public void givenFileName_whenImproper_shouldThrowException()
    {
        try {
            cricketLeagueAnalysis.loadIPLData(WRONG_CSV_FILE_TYPE);
        }
        catch (CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.FILE_NOT_FOUND,e.exceptionTypeObject);
        }
    }

    @Test
    public void givenStateCensusData_WhenWithWrongDelimiter_ThenShouldThrowException()
    {
        try {
            cricketLeagueAnalysis.loadIPLData(WRONG_DELIMITER_FILE);
        }
        catch (CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.WRONG_DELIMITER_FILE,e.exceptionTypeObject);
        }
    }

    @Test
    public void givenIPLDataFile_WhenHeaderIsWrong_ThenShouldThrowException()
    {
        try {
            cricketLeagueAnalysis.loadIPLData(WRONG_DELIMITER_FILE); }
        catch (CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.WRONG_DELIMITER_FILE,e.exceptionTypeObject);
        }
    }

    @Test
    public void whenGivenBatsmanStats_ShouldReturnPlayerWithBestBattingAverage() {
        cricketLeagueAnalysis.loadIPLData(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getTopBattingaverage();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName=batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("MS Dhoni",playerName);
    }

    @Test
    public void givenCricketLeagueData_whenSorted_shouldReturnBestStrickRate() {
        cricketLeagueAnalysis.loadIPLData(BATSMAN_CSV_FILE_PATH);
        String sorteddata = cricketLeagueAnalysis.getTopStrickeRate();
        CSVRunner[] batsmanCSVS = new Gson().fromJson(sorteddata, CSVRunner[].class);
        String playerName = batsmanCSVS[0].getPLAYER();
        Assert.assertEquals("Ishant Sharma", playerName);
    }
}
