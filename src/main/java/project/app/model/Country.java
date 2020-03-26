package project.app.model;

public class Country {
    private String name;
    private int confirmed;
    private int deaths;
    private int recovered;

    public Country(String name, int confirmed, int deaths, int recovered){
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

    public void addProvince(String name, Province infoProvince){

    }

}
