package com.bl.analysis.model;
import com.opencsv.bean.CsvBindByName;
public class CSVRunner {
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


