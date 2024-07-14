package in.ineuron.dao;

import in.ineuron.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {

public User findUserByFirstName(String firstName);
}
