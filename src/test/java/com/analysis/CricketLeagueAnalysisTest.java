package com.analysis;
import com.bl.analysis.exception.CricketLeagueAnalysisException;
import com.bl.analysis.model.CricketLeagueAnalysis;
import org.junit.Assert;
import org.junit.Test;
import static com.bl.analysis.model.FileUtility.*;

public class CricketLeagueAnalysisTest {
    CricketLeagueAnalysis cricketLeagueAnalysis;

    public void setUP() {
        cricketLeagueAnalysis = new CricketLeagueAnalysis();
    }

    /* TC:1.1 Check Number of Record matches of CSV file */
    @Test
    public void givenCsvFile_whenNumberOfRecordMatches_thenReturnTrue() {
        try {
            int numberOdRecords = cricketLeagueAnalysis.LoadIPLData(IPL_RUN_SHEET);
            Assert.assertEquals(100, numberOdRecords);
        } catch (CricketLeagueAnalysisException e) {
        }
    }
    /* T.C 1.2 :Given IPL Csv File Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenStateCensusData_WhenWithWrongFile_ThenShouldThrowException()
    {
        try {
            cricketLeagueAnalysis.LoadIPLData(WRONG_CSV_FILE_Name);
        } catch ( CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.FILE_NOT_FOUND,e.exceptionTypeObject);
        }
    }

    /* T.C 1.3 :Given IPL Csv Type Is Incorrect Then Returns Custom Exception */
    @Test
    public void givenFileName_whenImproper_shouldThrowException()
    {
        try {
            cricketLeagueAnalysis.LoadIPLData(WRONG_CSV_FILE_TYPE); }
        catch (CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.FILE_NOT_FOUND,e.exceptionTypeObject); }
    }
}
