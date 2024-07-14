package in.ineuron.service;

import in.ineuron.dao.ICoronaVaccineRepo;
import in.ineuron.model.CoronaVaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	/*
	@Override
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties) {

		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		Iterable<CoronaVaccine> listEntities = repo.findAll(sort);
		return listEntities;
	}*/

	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {

		Pageable pageable = PageRequest.of(pageNo, pageSize, asc ? Direction.ASC : Direction.DESC, properties);
		Page<CoronaVaccine> page = repo.findAll(pageable);
		return page.getContent();
	}
}

