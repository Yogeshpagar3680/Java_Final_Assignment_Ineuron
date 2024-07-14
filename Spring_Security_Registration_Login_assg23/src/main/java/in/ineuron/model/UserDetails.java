package in.ineuron.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name = "SECURITY_USERS")
@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(length = 20, unique = true, nullable = false)
    private String uname;

    @Column(length = 150, unique = true, nullable = false)
    private String pwd;

    @Column(length = 20, unique = true, nullable = false)
    private String email;

    private boolean status = true;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "SECURITY_ROLES",joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "uid"))
    @Column(name = "role")
    private Set<String> roles;
}
