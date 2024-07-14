package in.ineuron.controller;

import in.ineuron.model.UserDetails;
import in.ineuron.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("/register")
    public String showRegistrationPage(@ModelAttribute("userInfo") UserDetails details){
        return "user_register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userInfo") UserDetails userDetails, Map<String,Object> map){
       String resultMsg = service.register(userDetails);
       map.put("message",resultMsg);
       return "user_registered_success";
    }

    @RequestMapping("/showLogin")
    public String showLoginPage() {
        return "custom_login";
    }
}
