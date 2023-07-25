package screenmatch.models;

import screenmatch.calculation.Rank;

public class Movie extends Title implements Rank {
    private String director;

    public Movie(String name, int releaseYear) {
        super(name, releaseYear);

    }

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

    @Override
    public String toString() {
        return "Filme: " + this.getName() + " (" + this.getReleaseYear() + ")";
    }
}

