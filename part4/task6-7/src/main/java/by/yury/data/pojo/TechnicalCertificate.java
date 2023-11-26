package by.yury.data.pojo;


import java.util.Objects;



public class TechnicalCertificate {

    private  String number;

    private  String series;

    private  String year;

    private  String regPlate;

    public TechnicalCertificate() {
    }

    public TechnicalCertificate(String number, String series, String year, String regPlate) {
        this.number = number;
        this.series = series;
        this.year = year;
        this.regPlate = regPlate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRegPlate() {
        return regPlate;
    }

    public void setRegPlate(String regPlate) {
        this.regPlate = regPlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechnicalCertificate that = (TechnicalCertificate) o;
        return Objects.equals(number, that.number) && Objects.equals(series, that.series) && Objects.equals(year, that.year) && Objects.equals(regPlate, that.regPlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, series, year, regPlate);
    }
}
