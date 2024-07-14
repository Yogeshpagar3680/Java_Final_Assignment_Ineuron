package in.ineuron.service.impl;

import in.ineuron.dao.IOrderRepo;
import in.ineuron.dao.IUserRepo;
import in.ineuron.entity.Order;
import in.ineuron.entity.User;
import in.ineuron.service.IUserOrdersMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("service")
public class IUserOrdersMgmtServiceImpl implements IUserOrdersMgmtService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    IOrderRepo orderRepo;

    @Override
    public String saveUser(User user) {
        Integer id = userRepo.save(user).getUserId();
        return "user is saved with user id :: " + id;
    }

    @Override
    public String saveOrder(Iterable<Order> orders) {
        for(Order userOrder : orders){
            orderRepo.save(userOrder);
        }
        return ((Set<Order>) orders).size()+" no of orders are saved";
    }

    @Override
    public List<Order> fetchOrdersByUserId(Integer userId) {
        return orderRepo.findOrdersByUserId(userId);
    }
}
