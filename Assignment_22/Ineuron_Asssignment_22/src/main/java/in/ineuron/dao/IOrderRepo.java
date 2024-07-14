package in.ineuron.dao;

import in.ineuron.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepo extends JpaRepository<Order,Integer> {

    @Query(value = "select * from USER_ORDERS where user_id = :userId",nativeQuery = true)
    List<Order> findOrdersByUserId(Integer userId);
}
