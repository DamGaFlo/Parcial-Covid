package project.app.services;

import org.json.JSONObject;

public interface HTTPconnectionServices{
    public JSONObject getCountriesImpact();
    public JSONObject getCountryImpact(String countryName);
}
