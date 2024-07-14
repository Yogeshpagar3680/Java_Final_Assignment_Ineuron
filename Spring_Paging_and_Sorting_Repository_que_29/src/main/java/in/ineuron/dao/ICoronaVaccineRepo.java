package in.ineuron.dao;

import in.ineuron.model.CoronaVaccine;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoronaVaccineRepo extends PagingAndSortingRepository<CoronaVaccine, Long> {

	
}
