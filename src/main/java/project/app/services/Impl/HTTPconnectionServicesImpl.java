package project.app.services.Impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import project.app.services.HTTPconnectionServices;

@Service
public class HTTPconnectionServicesImpl implements HTTPconnectionServices {
    @Override
    public JSONObject getCountriesImpact() {
        try {
            HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "44dcd8f5d7mshf550bed2a1a379dp1fc49djsnf9da109a1513")
                    .asString();
            return new JSONObject(response.getBody()).getJSONObject("data");
        } catch (UnirestException | JSONException e) {
            return null;
        }
    }
    @Override
    public JSONObject getCountryImpact(String countryName) {
        HttpResponse<String> response;
        try {
            response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+countryName)
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "44dcd8f5d7mshf550bed2a1a379dp1fc49djsnf9da109a1513")
                    .asString();
            return new JSONObject(response.getBody()).getJSONObject("data");
        } catch (UnirestException | JSONException e) {
            return null;
        }
    }
}


