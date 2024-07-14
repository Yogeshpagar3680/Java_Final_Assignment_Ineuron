package in.ineuron.repository;

import in.ineuron.model.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserDetailsRepo extends CrudRepository<UserDetails,Integer> {

    public Optional<UserDetails> findByUname(String uname);
}
