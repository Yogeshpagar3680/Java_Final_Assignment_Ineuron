package in.ineuron.controller;

import in.ineuron.entity.Order;
import in.ineuron.entity.User;
import in.ineuron.service.IUserOrdersMgmtService;
import in.ineuron.service.impl.IUserOrdersMgmtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class userController {

    @Autowired
    IUserOrdersMgmtService service;

   @GetMapping("/get/orders/{userId}")
    public ResponseEntity<List> displayOrderByUserId(@PathVariable("userId") Integer userId){

        List<Order> orders = service.fetchOrdersByUserId(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}

