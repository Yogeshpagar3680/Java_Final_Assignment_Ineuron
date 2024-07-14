package in.ineuron.service;

import in.ineuron.model.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    public String register(UserDetails details);
}
