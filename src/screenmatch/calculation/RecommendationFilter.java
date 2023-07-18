package screenmatch.calculation;

public class RecommendationFilter {
    private String recommendation;

    public void filter(Rank rank){
        if (rank.getRanking() >=4) {
            System.out.println("Está entre os preferidos do momento");
        } else if (rank.getRanking() >= 2) {
            System.out.println("Muito bem avaliado no momento!");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}
