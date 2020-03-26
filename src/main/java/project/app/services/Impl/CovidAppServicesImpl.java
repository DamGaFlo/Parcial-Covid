package project.app.services.Impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.app.model.Country;
import project.app.model.GestionData;
import project.app.model.Statistics;
import project.app.persistence.CacheCovid19;
import project.app.services.CovidAppServices;
import project.app.services.HTTPconnectionServices;

import java.util.Collections;
import java.util.List;


@Service
public class CovidAppServicesImpl implements CovidAppServices {
    @Autowired
    private HTTPconnectionServices httpConnectionServices;

    @Autowired
    private CacheCovid19 cache;

    @Override
    public List<Country> getCountries() throws JSONException {
        GestionData data = new GestionData();

        JSONObject info = httpConnectionServices.getCountriesImpact();
        JSONArray arr = info.getJSONArray("covid19Stats");
        for(int i=0;i<arr.length();i++) {
            JSONObject object = arr.getJSONObject(i);
            data.addData(new Statistics(object.getString("city"),
                            object.getString("province"),
                            object.getString("country"),
                            object.getInt("confirmed"),
                            object.getInt("deaths"),
                            object.getInt("recovered")));
        }

        return data.getCountries();
    }


    @Override
    public Country getCountryByName(String name) throws JSONException {
        Country ansCountry = cache.loadCountry(name);
        if(ansCountry==null){
            ansCountry = new Country(name,0,0,0);
            JSONObject info = httpConnectionServices.getCountryImpact(name);
            JSONArray arr = info.getJSONArray("covid19Stats");
            for(int i=0;i<arr.length();i++) {
                JSONObject object = arr.getJSONObject(i);
                ansCountry.updateCountry(new Statistics(object.getString("city"),
                        object.getString("province"),
                        object.getString("country"),
                        object.getInt("confirmed"),
                        object.getInt("deaths"),
                        object.getInt("recovered")));
                
            }


        }
        return ansCountry;
    }
}
