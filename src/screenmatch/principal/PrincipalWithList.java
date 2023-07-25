package screenmatch.principal;

import screenmatch.models.Movie;
import screenmatch.models.Sitcom;
import screenmatch.models.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalWithList {
    public static void main(String[] args) {
        Movie myMovie = new Movie("The Godfather", 1972);
        myMovie.avaluate(10);
        Movie otherMovie = new Movie("Bad Boy 2", 2003);
        otherMovie.avaluate(8);
        Movie movieJoel = new Movie("Norbit", 2007);
        movieJoel.avaluate(6);
        Sitcom friends = new Sitcom("Friends", 1994);

        ArrayList<Title> list = new ArrayList<>();
        list.add(movieJoel);
        list.add(myMovie);
        list.add(otherMovie);
        list.add(friends);
        for (Title item: list) {
            System.out.println(item.getName());
            if (item instanceof Movie movie && movie.getRanking() > 2) {
                System.out.println("Classificação: " + movie.getRanking());
            }
        }

        List<String> searchByArtist = new ArrayList<>();
        searchByArtist.add("Will Smith");
        searchByArtist.add("Adam Sandler");
        searchByArtist.add("Chris Rock");
        System.out.println(searchByArtist);


        Collections.sort(searchByArtist);
        System.out.println("Depois da ordenação: ");
        System.out.println(searchByArtist);
        System.out.println("Lista de titulos ordenados: ");
        Collections.sort(list);
        System.out.println(list);
        list.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println("Ordenando por ano: ");
        System.out.println(list);

    }
}
