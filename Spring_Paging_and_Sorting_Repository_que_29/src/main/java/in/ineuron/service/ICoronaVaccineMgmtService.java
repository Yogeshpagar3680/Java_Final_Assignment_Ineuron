package in.ineuron.service;

import in.ineuron.model.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	//public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties);

	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties);
}
