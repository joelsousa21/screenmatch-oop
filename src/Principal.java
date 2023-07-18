import screenmatch.calculation.RecommendationFilter;
import screenmatch.calculation.TimeCalculator;
import screenmatch.models.Episode;
import screenmatch.models.Movie;
import screenmatch.models.Sitcom;

public class Principal {
    public static void main(String[] args) {
        Movie myMovie = new Movie();
        myMovie.setName("The Godfather");
        myMovie.setReleaseYear(1972);
        myMovie.setDurationInMinutes(175);
        System.out.println("Duração do filme: : " + myMovie.getDurationInMinutes());


        myMovie.displayTechnicalRecord();
        myMovie.avaluate(9);
        myMovie.avaluate(5);
        myMovie.avaluate(10);

        System.out.println("Total de avaliações: " + myMovie.getTotalOfAvaliations());
        System.out.println(myMovie.getMedia());
//        myMovie.sumOfAvaluations = 10;
//        myMovie.totalOfAvaliations = 1;
//        System.out.println(myMovie.getMedia());

        Sitcom friends = new Sitcom();

        friends.setName("Friends");
        friends.setReleaseYear(1994);
        friends.displayTechnicalRecord();
        friends.setSeasons(10);
        friends.setEpisodesPerSeason(16);
        friends.setMinutesPerEpisode(20);

        System.out.println("Duração para maratonar Friends: " + friends.getDurationInMinutes());

        Movie otherMovie = new Movie();
        otherMovie.setName("Bad Boy 2");
        otherMovie.setReleaseYear(2003);
        otherMovie.setDurationInMinutes(119);

        TimeCalculator calculator = new TimeCalculator();
        calculator.include(myMovie);
        calculator.include(otherMovie);
        calculator.include(friends);
        System.out.println(calculator.getTotalTime());

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(myMovie);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSitcom(friends);
        episode.setTotalVisualization(300);
        filter.filter(episode);

    }
}
