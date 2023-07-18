package screenmatch.models;

public class Title {
    private String name;
    private int releaseYear;
    private boolean includedInPlan;
    private double sumOfAvaluations;
    private int totalOfAvaliations;
    private int durationInMinutes;

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
}
