package in.ineuron.service;

import in.ineuron.dao.TouristRepo;
import in.ineuron.entity.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristServiceImpl implements TouristService{

    @Autowired
    TouristRepo touristRepo;

    @Override
    public String saveTourist(Tourist tourist) {
        Integer id = touristRepo.save(tourist).getTicketId();
        return "Tourist is saved with ticket id :: " + id;
    }
}
