package in.ineuron.controller;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

    @Autowired
    private ITouristMgmtService service;

    @PostMapping("/register")
    public ResponseEntity<String> enrolTourist(@RequestBody Tourist tourist) {
        try {
            String resultMsg = service.registerTourist(tourist);
            return new ResponseEntity<String>(resultMsg, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>("Problem in tourist enrollment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> displayTouristDetails() {
        try {
            List<Tourist> list = service.fetchAllTourist();
            return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>("Problems in fetching records", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) {
        try {
            Tourist tourist = service.fetchTouristById(id);
            return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {

        try {
            String msg = service.updateTouristByDetails(tourist);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/budgetModify/{id}/{hike}")
    public ResponseEntity<String> modifyTouristBudgetById(@PathVariable("id") Integer id,
                                                          @PathVariable("hike") Float hikeAmt)
    {
        try {
            String msg = service.updateTouristById(id,hikeAmt);
            return new ResponseEntity<String>(msg,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeTouristById(@PathVariable("id") Integer id) {

        try {
            String msg = service.deleteTouristById(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
