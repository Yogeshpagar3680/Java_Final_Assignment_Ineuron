package in.ineuron.service;

import in.ineuron.model.UserDetails;
import in.ineuron.repository.IUserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDetailsRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public String register(UserDetails details) {
        details.setPwd(encoder.encode(details.getPwd()));
        return repo.save(details).getUid() + "UserId is registered!";
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> optional = repo.findByUname(username);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("user not found");
        } else {

            UserDetails details = optional.get();

            User user = new User(details.getUname(), details.getPwd(), details.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
            return user;
        }
    }
}
