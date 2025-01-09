package User;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public enum Role {
        ADMIN, MANAGER, COURIER
    }
    GetMapping("/role")
    public Map<String, String> getUserRole(Authentication authentication) {
        String role = authentication.getAuthorities().iterator().next().getAuthority();
        return Collections.singletonMap("role", role);
    }

}
