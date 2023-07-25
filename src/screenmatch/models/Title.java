package screenmatch.models;

import com.google.gson.annotations.SerializedName;
import screenmatch.exception.ErrorOfYearConvertionException;

public class Title implements Comparable<Title>  {
    private String name;
    private int releaseYear;
    private boolean includedInPlan;
    private double sumOfAvaluations;
    private int totalOfAvaliations;
    private int durationInMinutes;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(TitleOmdb myTitleOmdb) {
        this.name = myTitleOmdb.title();
        if(myTitleOmdb.year().length() > 4) {
            throw new ErrorOfYearConvertionException("Não consegui converter o ano, porque tem mais de 4 caracteres.");
        }
        this.releaseYear = Integer.valueOf(myTitleOmdb.year());
        this.durationInMinutes = Integer.valueOf(myTitleOmdb.runtime().substring(0,3));

    }

    public int getTotalOfAvaliations(){
        return totalOfAvaliations;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void displayTechnicalRecord(){
        System.out.println("Nome do Filme: " + name);
        System.out.println("Ano de lançamento: " + releaseYear);
    }

    public void avaluate(double note){
        sumOfAvaluations += note;
        totalOfAvaliations++;
    }

    public double getMedia(){
        return sumOfAvaluations / totalOfAvaliations;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "(name='" + name + '\'' +
                ", releaseYear=" + releaseYear + "," + "durationInMinutes="+durationInMinutes + ")";
    }
}
