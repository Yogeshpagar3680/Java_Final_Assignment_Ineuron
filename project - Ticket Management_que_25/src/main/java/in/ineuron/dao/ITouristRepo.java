package in.ineuron.dao;

import in.ineuron.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITouristRepo extends JpaRepository<Tourist,Integer> {
}
