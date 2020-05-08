package com.analysis;
import com.bl.analysis.model.CricketLeagueAnalysis;
import org.junit.Assert;
import org.junit.Test;
import static com.bl.analysis.model.FileUtility.IPL_RUN_SHEET;

public class CricketLeagueAnalysisTest {
    CricketLeagueAnalysis cricketLeagueAnalysis;

    public void setUP() {
        cricketLeagueAnalysis = new CricketLeagueAnalysis();
    }

    @Test
    public void givenCsvFile_whenNumberOfRecordMatches_thenReturnTrue() {
        try {
            int numberOdRecords = cricketLeagueAnalysis.LoadIPLData(IPL_RUN_SHEET);
            Assert.assertEquals(100, numberOdRecords);
        } catch (Exception e) {
        }
    }
}