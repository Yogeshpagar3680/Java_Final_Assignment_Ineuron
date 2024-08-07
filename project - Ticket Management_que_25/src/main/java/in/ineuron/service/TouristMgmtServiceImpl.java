package in.ineuron.service;

import in.ineuron.dao.ITouristRepo;
import in.ineuron.exception.TouristNotFoundException;
import in.ineuron.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {

    @Autowired
    private ITouristRepo repo;

    @Override
    public String registerTourist(Tourist tourist) {
        Integer tid = repo.save(tourist).getTicketId();
        return "Tourist is registered having the ticket id :: " + tid;
    }

    @Override
    public List<Tourist> fetchAllTourist() {
        List<Tourist> list = repo.findAll();
        list.sort((t1,t2) -> (t1.getTicketId().compareTo(t2.getTicketId())));
        return list;
    }

    @Override
    public Tourist fetchTouristById(Integer id) {
        Optional<Tourist> optional = repo.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        else {
            throw new TouristNotFoundException("tourist with id " + id + " not found");
        }
    }

    @Override
    public String updateTouristByDetails(Tourist tourist) {

        Optional<Tourist> optional = repo.findById(tourist.getTicketId());
        if(optional.isPresent()) {
            repo.save(tourist); //save performs both insert and update depends on id value
            return "Tourist with the id :: " + tourist.getTicketId() +  " updated" ;
        }
        else {
            throw new TouristNotFoundException("Tourist with id " + tourist.getTicketId() + " not available for updation");
        }
    }

    @Override
    public String updateTouristById(Integer id, Float hikePercent) {
        Optional<Tourist> optional = repo.findById(id);
        if(optional.isPresent()) {
            Tourist tourist = optional.get();
            tourist.setBudget(tourist.getBudget() + tourist.getBudget() * hikePercent/100);
            repo.save(tourist);//save + update
            return "tourist budget is updated for the id :: " + tourist.getTicketId();
        }
        else {
            throw new TouristNotFoundException("Tourist not found for the id :: " + id);
        }
    }

    @Override
    public String deleteTouristById(Integer id) {
        Optional<Tourist> optional = repo.findById(id);
        if(optional.isPresent()){
            repo.delete(optional.get());
            return "Tourist with id " + id + " deleted...";
        }
        else {
            throw new TouristNotFoundException("Tourist not found with id :: " + id + " for deletion");
        }
    }
}
