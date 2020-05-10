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
    private String Ov;
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

    public String getPOS() {
        return POS;
    }

    public void setPOS(String POS) {
        this.POS = POS;
    }

    public String getPLAYER() {
        return PLAYER;
    }

    public void setPLAYER(String PLAYER) {
        this.PLAYER = PLAYER;
    }

    public String getMat() {
        return Mat;
    }

    public void setMat(String mat) {
        Mat = mat;
    }

    public String getInns() {
        return Inns;
    }

    public void setInns(String inns) {
        Inns = inns;
    }

    public String getOv() {
        return Ov;
    }

    public void setOv(String ov) {
        Ov = ov;
    }

    public double getRuns() {
        return Runs;
    }

    public void setRuns(double runs) {
        Runs = runs;
    }

    public double getWkts() {
        return Wkts;
    }

    public void setWkts(double wkts) {
        Wkts = wkts;
    }

    public String getBBI() {
        return BBI;
    }

    public void setBBI(String BBI) {
        this.BBI = BBI;
    }

    public double getAvg() {
        return Avg;
    }

    public void setAvg(double avg) {
        Avg = avg;
    }

    public double getEcon() {
        return Econ;
    }

    public void setEcon(double econ) {
        Econ = econ;
    }

    public double getSR() {
        return SR;
    }

    public void setSR(double SR) {
        this.SR = SR;
    }

    public String getFourWickets() {
        return FourWickets;
    }

    public void setFourWickets(String fourWickets) {
        FourWickets = fourWickets;
    }

    public String getFiveWickets() {
        return FiveWickets;
    }

    public void setFiveWickets(String fiveWickets) {
        FiveWickets = fiveWickets;
    }

}
