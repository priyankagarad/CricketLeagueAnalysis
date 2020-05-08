package com.analysis;
import com.bl.analysis.exception.CricketLeagueAnalysisException;
import com.bl.analysis.model.CricketLeagueAnalysis;
import org.junit.Assert;
import org.junit.Test;
import static com.bl.analysis.model.FileUtility.IPL_RUN_SHEET;
import static com.bl.analysis.model.FileUtility.WRONG_CSV_FILE_PATH;

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
            cricketLeagueAnalysis.LoadIPLData(WRONG_CSV_FILE_PATH);
        } catch ( CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.FILE_NOT_FOUND,e.exceptionTypeObject);
        }
    }
}
