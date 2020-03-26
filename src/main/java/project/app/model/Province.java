package project.app.model;

import java.util.concurrent.ConcurrentHashMap;

public class Province {
    private String name;
    private int confirmed;
    private  int deaths;
    private int recovered;
    ConcurrentHashMap<String,City> cities;

    public Province(String name, int confirmed,int deaths, int recovered){
        this.name = name;
        this.recovered = recovered;
        this.deaths = deaths;
        this.confirmed = confirmed;
    }

    public String getName() {
        return name;
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

    public void addCity(String name,City infoCity){
        if(cities.contains(name)){
            updateCity(name,infoCity);
        }
        else{
            confirmed += infoCity.getConfirmed();
            deaths += infoCity.getDeaths();
            recovered += infoCity.getRecovered();
            cities.put(name,infoCity);
        }
    }

    private void updateCity(String name,City infoCity){
        City oldCity = cities.get(name);
        confirmed += infoCity.getConfirmed() - oldCity.getConfirmed();
        deaths += infoCity.getDeaths() - oldCity.getDeaths();
        recovered += infoCity.getRecovered() - oldCity.getRecovered();
        cities.replace(name,infoCity);
    }
}
