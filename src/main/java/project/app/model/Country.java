package project.app.model;

import java.util.concurrent.ConcurrentHashMap;

public class Country {
    private String name;
    private int confirmed;
    private int deaths;
    private int recovered;
    ConcurrentHashMap<String,Province> provinces= new ConcurrentHashMap<>();;

    public Country(String name, int confirmed, int deaths, int recovered){
        this.name = name;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;


    }

    public Country(String name){
        this.name = name;
        this.confirmed = 0;
        this.deaths = 0;
        this.recovered = 0;
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

    public void updateCountry(Statistics data){
        if(provinces.contains(data.getProvince())){
            if(data.getCity().isEmpty()){
                updatStats(data.getConfirmed(),data.getDeaths(),data.getRecovered());
            } else{
                int oldConfirmed = provinces.get(data.getProvince()).getConfirmed();
                int oldDeaths = provinces.get(data.getProvince()).getDeaths();
                int oldRecovered = provinces.get(data.getProvince()).getRecovered();
                provinces.get(data.getProvince()).addCity(data.getCity(),new City(data.getCity(),data.getConfirmed(),data.getDeaths(),data.getRecovered()));

                updatStats(provinces.get(data.getProvince()).getConfirmed()-oldConfirmed,
                        provinces.get(data.getProvince()).getDeaths()-oldDeaths,
                        provinces.get(data.getProvince()).getRecovered()-oldRecovered);
            }
        }else{
            if(data.getCity().isEmpty()){
                updatStats(data.getConfirmed(),data.getDeaths(),data.getRecovered());
                provinces.put(data.getProvince(),new Province(data.getProvince(),data.getConfirmed(),data.getDeaths(),data.getRecovered()));
            }else{
                updatStats(data.getConfirmed(),data.getDeaths(),data.getRecovered());
                provinces.put(data.getProvince(),new Province(data.getProvince(),0,0,0));
                provinces.get(data.getProvince()).addCity(data.getCity(),new City(data.getCity(),data.getConfirmed(),data.getDeaths(),data.getRecovered()));

            }
        }

    }

    public void addProvince(String name, Province infoProvince){
        if(provinces.contains(name)){
            updateProvince(name,infoProvince);
        }
        else{
            confirmed += infoProvince.getConfirmed();
            deaths += infoProvince.getDeaths();
            recovered += infoProvince.getRecovered();
        }
    }

    private void updateProvince(String name,Province infoProvince){
        Province oldProvince = provinces.get(name);
        confirmed += infoProvince.getConfirmed() - oldProvince.getConfirmed();
        deaths += infoProvince.getDeaths() - oldProvince.getDeaths();
        recovered += infoProvince.getRecovered() - oldProvince.getRecovered();
        provinces.replace(name,infoProvince);
    }

    private void updatStats(int confirmed,int deaths, int recovered){
        this.confirmed+=confirmed;
        this.recovered+=recovered;
        this.deaths+=deaths;

    }

}
