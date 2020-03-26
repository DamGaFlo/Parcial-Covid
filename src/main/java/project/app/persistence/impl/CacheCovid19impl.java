package project.app.persistence.impl;

import org.springframework.stereotype.Service;
import project.app.model.Country;
import project.app.model.Province;
import project.app.persistence.CacheCovid19;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheCovid19impl implements CacheCovid19 {
    ConcurrentHashMap<String,Country> countries;

    @Override
    public void saveCountry(String name, Country infoCountry){
        if(countries.contains(name)) {
            countries.replace(name,infoCountry);
        }
        else{
            countries.put(name,infoCountry);
        }
    }

    @Override
    public Country loadCountry(String name){
        Country countryAns = null;
        if(countries.contains(name)) {
            countryAns = countries.get(name);
        }
        return countryAns;
    }


}
