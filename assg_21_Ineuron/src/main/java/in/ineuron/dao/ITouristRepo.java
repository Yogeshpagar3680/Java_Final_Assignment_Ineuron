package in.ineuron.dao;

import in.ineuron.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITouristRepo extends JpaRepository<Tourist,Integer> {
}
