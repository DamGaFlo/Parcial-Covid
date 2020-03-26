package project.app.model;

import java.util.*;

public class GestionData {

    List<Country> countries = new ArrayList<>();

    public void addData(Statistics data){
        Boolean tes = false;
        for(Country i:countries){
            if(i.getName().equals(data.getCountry())){
                i.updateCountry(data);
                tes = true;
                break;
            }

        }
        if(!tes){
            Country country = new Country(data.getCountry(),0,0,0);
            country.updateCountry(data);
            countries.add(country);
        }
    }


    public List<Country> getCountries() {
        return countries;
    }
}
