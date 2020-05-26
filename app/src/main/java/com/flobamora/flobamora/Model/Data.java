package com.flobamora.flobamora.Model;

public class Data {
    private String DataName;
    private String DataSrc;
    private String DataScore;

    public Data() {

    }

    public Data(String dataName, String dataSrc, String dataScore) {
        DataName = dataName;
        DataSrc = dataSrc;
        DataScore = dataScore;
    }

    public String getDataName() {
        return DataName;
    }

    public void setDataName(String dataName) {
        DataName = dataName;
    }

    public String getDataSrc() {
        return DataSrc;
    }

    public void setDataSrc(String dataSrc) {
        DataSrc = dataSrc;
    }

    public String getDataScore() {
        return DataScore;
    }

    public void setDataScore(String dataScore) {
        DataScore = dataScore;
    }
}
