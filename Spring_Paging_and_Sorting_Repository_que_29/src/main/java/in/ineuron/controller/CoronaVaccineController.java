package in.ineuron.controller;

import in.ineuron.model.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoronaVaccineController {

    @Autowired
    ICoronaVaccineMgmtService service;

    @GetMapping("/get/vaccines/{pageNo}")
    public ResponseEntity<List> displayVaccinesByPageNo(@PathVariable Integer pageNo){
        List<CoronaVaccine> coronaVaccineList = (List<CoronaVaccine>) service.fetchDetailsByPageNo(pageNo, 2, false, "price", "name");
        return new ResponseEntity<>(coronaVaccineList,HttpStatus.OK);
    }
}
