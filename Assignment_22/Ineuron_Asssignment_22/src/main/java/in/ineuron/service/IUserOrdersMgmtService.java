package in.ineuron.service;

import in.ineuron.entity.Order;
import in.ineuron.entity.User;

import java.util.List;

public interface IUserOrdersMgmtService {

    public String saveUser(User user);
    public String saveOrder(Iterable<Order> orders);
    public List<Order> fetchOrdersByUserId(Integer userId);
}
