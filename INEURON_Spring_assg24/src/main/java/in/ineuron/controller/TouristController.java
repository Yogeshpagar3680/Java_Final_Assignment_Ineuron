package in.ineuron.controller;

import in.ineuron.entity.Tourist;
import in.ineuron.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

    @Autowired
    TouristService service;

    @PostMapping("/save")
    public ResponseEntity<String> saveTourist(@RequestBody Tourist tourist){
        String message = service.saveTourist(tourist);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
