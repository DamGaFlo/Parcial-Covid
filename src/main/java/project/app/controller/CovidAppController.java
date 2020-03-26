package project.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.app.persistence.CacheCovid19;
import project.app.services.CovidAppServices;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class CovidAppController {

    @Autowired
    CovidAppServices covidAppServices;

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public ResponseEntity<?> getCountries(){
        try{
            return new ResponseEntity<>(covidAppServices.getCountries(), HttpStatus.ACCEPTED);

        }catch(Exception ex){
            Logger.getLogger(CovidAppController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error al encontrar el pais", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/country/{nameCountry}", method = RequestMethod.GET)
    public ResponseEntity<?> getCountries(@PathVariable("nameCountry") String nameCountry){
        try{
            return new ResponseEntity<>(covidAppServices.getCountryByName(nameCountry), HttpStatus.ACCEPTED);

        }catch(Exception ex){
            Logger.getLogger(CovidAppController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error el pais", HttpStatus.FORBIDDEN);
        }
    }
}
