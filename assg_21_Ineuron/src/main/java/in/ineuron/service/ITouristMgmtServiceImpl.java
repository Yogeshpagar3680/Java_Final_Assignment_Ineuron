package in.ineuron.service;

import in.ineuron.dao.ITouristRepo;
import in.ineuron.entity.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class ITouristMgmtServiceImpl implements ITouristMgmtService {

    @Autowired
    ITouristRepo repo;

    @Override
    public String registerTourist(Tourist tourist) {
        Integer tid = repo.save(tourist).getTicketId();
        return "Tourist is registered having the ticket id :: " + tid;
    }
}
