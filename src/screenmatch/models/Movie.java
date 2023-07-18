package screenmatch.models;

import screenmatch.calculation.Rank;

public class Movie extends Title implements Rank {
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getRanking() {
        return (int) getMedia() / 2;
    }
}
