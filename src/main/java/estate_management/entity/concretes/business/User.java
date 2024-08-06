package estate_management.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.entity.concretes.user.UserRole;
import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false, length = 30)
    @Size(min = 2, max = 30, message = "firstName must be between 2 and 30 characters")
    @NotNull(message = "firstName cannot be null")
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 30)
    @Size(min = 2, max = 30, message = "lastName must be between 2 and 30 characters")
    @NotNull(message = "lastName cannot be null")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 80)
    @Size(min = 10, max = 80, message = "email must be between 10 and 80 characters")
    @NotNull(message = "email cannot be null")
    @Email
    private String email;

    @Column(name = "phone", nullable = false)
    @NotNull(message = "phone cannot be null")
    private String phone;


    @Column(name = "passwordHash", nullable = false)
    @NotNull
    private String passwordHash;


    @Column(name = "resetPasswordCode", nullable = true)
    private String resetPasswordCode;

    @Column(name = "built_in", nullable = false)
    @NotNull(message = "built_in can not be null")
    private Boolean builtIn = false;

    @Column(name = "create_at", nullable = false)
    @NotNull(message = "Create cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles;

    @ManyToMany(mappedBy = "user")
    private Set<Favorite> favorite;


    @OneToMany(mappedBy = "user")
    private List<Log> log;

    @OneToMany(mappedBy="user")
    private Set<TourRequest> tourRequest;


    @PrePersist
    private void onCreate() {
        create_at = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
