package in.ineuron.service;

import com.netflix.discovery.converters.Auto;
import in.ineuron.dao.PersonRepo;
import in.ineuron.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonEntityServiceImpl implements PersonEntityService{

    @Autowired
    PersonRepo personRepo;

    @Override
    public List<PersonEntity> fetchPersonEntity() {
        return personRepo.findAll();
    }
}
