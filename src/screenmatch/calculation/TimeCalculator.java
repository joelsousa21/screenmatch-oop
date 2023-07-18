package screenmatch.calculation;

import screenmatch.models.Movie;
import screenmatch.models.Sitcom;
import screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return this.totalTime;
    }

//    public void include(Movie m) {
//        this.totalTime += m.getDurationInMinutes();
//    }
//
//    public void include(Sitcom s) {
//        this.totalTime += s.getDurationInMinutes();
//    }

    public void include(Title title){
        System.out.println("Adicionando duraçaõ em minutos de " + title.getName());
        this.totalTime += title.getDurationInMinutes();
    }
}
