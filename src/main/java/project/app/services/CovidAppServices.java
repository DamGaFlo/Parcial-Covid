package project.app.services;

import org.json.JSONException;
import project.app.model.Country;

import java.util.List;


public interface CovidAppServices {
    public List<Country> getCountries() throws JSONException;

    public Country getCountryByName(String name) throws JSONException;
    
    
}
