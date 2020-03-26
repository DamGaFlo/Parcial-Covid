package project.app.persistence;

import project.app.model.Country;

public interface CacheCovid19 {

    public void saveCountry(String name, Country country);

    public Country loadCountry(String name);
}
