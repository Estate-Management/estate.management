package estate_management.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)

@Entity
@Table(name = "Favorite")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(name = "favorite_user",
    joinColumns = @JoinColumn(name = "favorite_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private List<User> user;

    @ManyToMany
    @JoinTable(name = "Favorite_advert",
    joinColumns = @JoinColumn(name = "favorite_id"),
    inverseJoinColumns = @JoinColumn(name = "advert_id"))
    @JsonIgnore
    private Set<Advert> advert;



    @Column(name = "create_at", nullable = false)
    @NotNull(message = "CreateAt cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime create_at;

    @PrePersist
    private void onCreate() {
        create_at = LocalDateTime.now();

    }

}
