package screenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import screenmatch.exception.ErrorOfYearConvertionException;
import screenmatch.models.Title;
import screenmatch.models.TitleOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        String search = "";
        List<Title> titles = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();


        while (!search.equalsIgnoreCase("Sair")){

            System.out.println("Digite um filme para busca: ");
            search = read.nextLine();

            String adress = "http://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=2a29f480";

            if(search.equalsIgnoreCase("Sair")){
                break;
            }

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(adress))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
                System.out.println(myTitleOmdb);
//        try {
                Title myTitle = new Title(myTitleOmdb);
                System.out.println("Título já convertido: ");
                System.out.println(myTitle);

                FileWriter write = new FileWriter("movies.txt");
                write.write(myTitle.toString());
                write.close();

                titles.add(myTitle);
            } catch (NumberFormatException/*NullPointerException | IllegalArgumentException */ e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço!");
            } catch (ErrorOfYearConvertionException e) {
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Ocorreu algum erro, verifique.");
            }
        }
        System.out.println(titles);

        FileWriter write = new FileWriter("movies.json");
        write.write(gson.toJson(titles));
        write.close();
        System.out.println("O programa finalizou corretamente!");
    }
}