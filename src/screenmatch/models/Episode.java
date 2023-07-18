package screenmatch.models;

import screenmatch.calculation.Rank;

public class Episode implements Rank {
    private int number;
    private String name;
    private Sitcom sitcom;
    private int totalVisualization;

    public int getTotalVisualization() {
        return totalVisualization;
    }

    public void setTotalVisualization(int totalVisualization) {
        this.totalVisualization = totalVisualization;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sitcom getSitcom() {
        return sitcom;
    }

    public void setSitcom(Sitcom sitcom) {
        this.sitcom = sitcom;
    }

    @Override
    public int getRanking() {
        if (totalVisualization > 100){
            return 4;
        } else {
            return 2;
        }

    }
}
