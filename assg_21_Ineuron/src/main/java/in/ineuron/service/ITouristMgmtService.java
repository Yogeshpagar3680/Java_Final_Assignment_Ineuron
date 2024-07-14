package in.ineuron.service;

import in.ineuron.entity.Tourist;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface ITouristMgmtService {

    public String registerTourist(Tourist tourist);
}
