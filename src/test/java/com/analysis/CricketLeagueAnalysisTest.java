package com.analysis;
import com.bl.analysis.exception.CricketLeagueAnalysisException;
import com.bl.analysis.model.CricketLeagueAnalysis;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.bl.analysis.model.FileUtility.*;
public class CricketLeagueAnalysisTest {
    CricketLeagueAnalysis cricketLeagueAnalysis;

    @Before
    public void setUP()
    {
        cricketLeagueAnalysis = new CricketLeagueAnalysis();
    }

    /* TC:1.1 Check Number of Record matches of CSV file */
    @Test
    public void givenCsvFile_whenNumberOfRecordMatches_thenReturnTrue() throws CricketLeagueAnalysisException {
        try {
            int numberOfRecords = cricketLeagueAnalysis.loadIPLData(IPL_RUN_SHEET);
             Assert.assertEquals(100, numberOfRecords);
        } catch (CricketLeagueAnalysisException e) {
        }
    }

    /* TC: 1.2 :Given IPL Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenIPLCsvFile_WhenWithWrongFile_ThenShouldThrowException()
    {
        try {
            cricketLeagueAnalysis.loadIPLData(WRONG_CSV_FILE_Name);
        } catch ( CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.FILE_NOT_FOUND,e.exceptionTypeObject);
        }
    }

    /* TC: 1.3 :Given IPL Csv Type Is Incorrect Then Returns Custom Exception */
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

    /* TC: 1.4 :Given IPLCsv file Is Correct But Wrong Delimiter Should throw Custom Exception */
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
    /* T.C 1.5 :Given IPL Csv file Header is Incorrect return Custom Exception */
    @Test
    public void givenIPLDataFile_WhenHeaderIsWrong_ThenShouldThrowException()
    {
        try {
            cricketLeagueAnalysis.loadIPLData(WRONG_DELIMITER_FILE); }
        catch (CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.WRONG_DELIMITER_FILE,e.exceptionTypeObject);
        }
    }
}
