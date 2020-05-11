package com.bl.analysis.model;
import com.opencsv.bean.CsvBindByName;
public class CSVRunner
{
    @CsvBindByName(column = "POS")
    private String POS;

    @CsvBindByName(column = "PLAYER")
    private String PLAYER;

    @CsvBindByName(column = "Mat")
    private String Mat;

    @CsvBindByName(column = "Inns")
    private String Inns;

    @CsvBindByName(column = "NO")
    private String NO;

    @CsvBindByName(column = "Runs")
    private String Runs;

    @CsvBindByName(column = "HS")
    private String HS;

    @CsvBindByName(column = "Avg")
    private double Avg;

    @CsvBindByName(column = "BF")
    private String BF;

    @CsvBindByName(column = "SR")
    private double SR;

    @CsvBindByName(column = "100")
    private String hundred;

    @CsvBindByName(column = "50")
    private String fifty;

    @CsvBindByName(column = "4s")
    private double fours;

    @CsvBindByName(column = "6s")
    private double sixs;

    public String getPLAYER () {
        return PLAYER;
    }

    public String getRuns() {
        return Runs;
    }

    public double getAvg () {
        return Avg;
    }

    public double getSR () { return SR;
    }

    public double getFours () { return fours;
    }

    public double getSixs () { return sixs;
    }
}


