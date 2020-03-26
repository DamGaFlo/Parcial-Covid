package project.app.model;

public class Statistics {
    private String city;
    private String province;
    private String Country;
    private int confirmed;
    private int deaths;
    private int recovered;

    public Statistics(String city, String province, String country, int confirmed, int deaths, int recovered) {
        this.city = city;
        this.province = province;
        Country = country;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }


    public int getRecovered() {
        return recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return Country;
    }

    public String getProvince() {
        return province;
    }

}
