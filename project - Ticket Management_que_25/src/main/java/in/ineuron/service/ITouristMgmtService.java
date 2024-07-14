package in.ineuron.service;

import in.ineuron.model.Tourist;

import java.util.List;

public interface ITouristMgmtService {

    public String registerTourist(Tourist tourist);
    public List<Tourist> fetchAllTourist();
    public Tourist fetchTouristById(Integer id);
    public String updateTouristByDetails(Tourist tourist);
    public String updateTouristById(Integer id, Float hikePercent);
    public String deleteTouristById(Integer id);
}
