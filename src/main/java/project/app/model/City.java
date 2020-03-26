package project.app.model;

public class City {
    private String name;
    private int confirmed;
    private  int deaths;
    private int recovered;

    public City(String name, int confirmed, int deaths, int recovered) {
        this.name = name;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public String getName() {
        return name;
    }

}
