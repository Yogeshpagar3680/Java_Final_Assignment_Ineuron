package in.ineuron.controller;

import com.netflix.discovery.converters.Auto;
import in.ineuron.service.PersonEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonEntityController {

    @Autowired
    PersonEntityService service;

    @GetMapping("/fetchAll")
    public ResponseEntity<List> displayAllPersons(){
        return new ResponseEntity<List>(service.fetchPersonEntity(), HttpStatus.OK);
    }
}
