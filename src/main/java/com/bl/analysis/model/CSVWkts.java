package com.bl.analysis.model;
import com.opencsv.bean.CsvBindByName;
public class CSVWkts {
    @CsvBindByName(column = "POS")
    private String POS;
    @CsvBindByName(column = "PLAYER")
    private String PLAYER;
    @CsvBindByName(column = "Mat")
    private String Mat;
    @CsvBindByName(column = "Inns")
    private String Inns;
    @CsvBindByName(column = "Ov")
    private double Ov;
    @CsvBindByName(column = "Runs")
    private double Runs;
    @CsvBindByName(column = "Wkts")
    private double Wkts;
    @CsvBindByName(column = "BBI")
    private String BBI;
    @CsvBindByName(column = "Avg")
    private double Avg;
    @CsvBindByName(column = "Econ")
    private double Econ;
    @CsvBindByName(column = "SR")
    private double SR;
    @CsvBindByName(column = "4w")
    private String FourWickets;
    @CsvBindByName(column = "5w")
    private String FiveWickets;

    public String getPLAYER() {
        return PLAYER;
    }

    public double getRuns() {
        return Runs;
    }

    public double getWkts() {
        return Wkts;
    }

    public double getAvg() {
        return Avg;
    }

    public double getEcon() {
        return Econ;
    }

    public double getSR() {
        return SR;
    }

    public String getFourWickets() {
        return FourWickets;
    }

    public String getFiveWickets() {
        return FiveWickets;
    }

    public double getOv() {
        return Ov;
    }
}
