package in.ineuron.runner;

import in.ineuron.entity.Order;
import in.ineuron.entity.User;
import in.ineuron.service.impl.IUserOrdersMgmtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AssociationRunner implements CommandLineRunner {

    @Autowired
    IUserOrdersMgmtServiceImpl service;

    @Override
    public void run(String... args) throws Exception {

        Order o1 = new Order("21-May-24","Milk");
        Order o2 = new Order("22-May-24","Eggs");

        User u = new User("seema","rathod");

        o1.setUser(u);
        o2.setUser(u);

        Set<Order> userOrders = Set.of(o1,o2);

        u.setOrderDetails(userOrders);

        System.out.println(service.saveUser(u));

        /*----------------------------------------------------------------*/

        Order order1 = new Order("21-Jan-24","Milk");
        Order order2 = new Order("22-Jan-24","Apples");

        User user = new User("Shubham","Patil");

        o1.setUser(user);
        o2.setUser(user);

        Set<Order> userOrders1 = Set.of(order1,order2);

        u.setOrderDetails(userOrders1);

        System.out.println(service.saveUser(user));

    }
}
