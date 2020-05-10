package com.bl.analysis.dao;
import com.bl.analysis.model.CSVRunner;
public class CricketPlayerDao {
    private String POS;
    private String PLAYER;
    private String Mat;
    private String Inns;
    private String NO;
    private String Runs;
    private String HS;
    private double Avg;
    private String BF;
    private double SR;
    private String hundred;
    private String fifty;
    private double fours;
    private double sixs;

    public CricketPlayerDao(CSVRunner csvRunner)
    {
        this.POS=csvRunner.getPOS();
        this.PLAYER=csvRunner.getPLAYER();
        this.Mat=csvRunner.getMat();
        this.Inns=csvRunner.getInns();
        this.NO=csvRunner.getNO();
        this.Runs=csvRunner.getRuns();
        this.HS=csvRunner.getHS();
        this.Avg=csvRunner.getAvg();
        this.BF=csvRunner.getBF();
        this.SR=csvRunner.getSR();
        this.hundred=csvRunner.getHundred();
        this.fifty=csvRunner.getFifty();
        this.fours=csvRunner.getFours();
        this.sixs=csvRunner.getSixs();
    }

    public String getPOS () {
        return POS;
    }

    public void setPOS (String POS){
        this.POS = POS;
    }

    public String getPLAYER () {
        return PLAYER;
    }

    public void setPLAYER (String PLAYER){
        this.PLAYER = PLAYER;
    }

    public String getMat () {
        return Mat;
    }

    public void setMat (String Mat){
        Mat = Mat;
    }

    public String getInns () {
        return Inns;
    }

    public void setInns (String inns){
        Inns = inns;
    }

    public String getNO () {
        return NO;
    }

    public void setNO (String NO){
        this.NO = NO;
    }

    public String getRuns() {
        return Runs;
    }

    public void setRuns (String runs){
        this.Runs = runs;
    }

    public String getHS () {
        return HS;
    }

    public void setHS (String HS){
        this.HS = HS;
    }

    public double getAvg () {
        return Avg;
    }

    public void setAvg (double avg){
        Avg = avg;
    }

    public String getBF () {
        return BF;
    }

    public void setBF (String BF){
        this.BF = BF;
    }

    public double getSR () {
        return SR;
    }

    public void setSR (double SR){
        this.SR = SR;
    }

    public String getHundred () {
        return hundred;
    }

    public void setHundred (String hundred){
        this.hundred = hundred;
    }

    public String getFifty () {
        return fifty;
    }

    public void setFifty (String fifty){
        this.fifty = fifty;
    }

    public double getFours () {
        return fours;
    }

    public void setFours (double fours){
        this.fours = fours;
    }

    public double getSixs () {
        return sixs;
    }

    public void setSixs (double sixs){
        this.sixs = sixs;
    }

    @Override
    public String toString() {
        return "CSVRunner{" +
                "POS='" + POS + '\'' +
                ", PLAYER='" + PLAYER + '\'' +
                ", Mat='" + Mat + '\'' +
                ", Inns='" + Inns + '\'' +
                ", NO='" + NO + '\'' +
                ", Runs='" + Runs + '\'' +
                ", HS='" + HS + '\'' +
                ", Avg='" + Avg + '\'' +
                ", BF='" + BF + '\'' +
                ", SR='" + SR + '\'' +
                ", hundred='" + hundred + '\'' +
                ", fifty='" + fifty + '\'' +
                ", fours='" + fours + '\'' +
                ", sixs='" + sixs + '\'' +
                '}';
    }
}


