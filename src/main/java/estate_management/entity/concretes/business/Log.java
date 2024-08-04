package estate_management.entity.concretes.business;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="log_name", nullable = false, length= 30)
    @NotNull(message = "Log cannot be null")
    @Size(max = 30)
    private String name;

    @ManyToOne
    private User user;;

    @ManyToOne
    private  Advert advert;

    @Column(name = "created_at", nullable = false)
    @NotNull(message = "Creation time cannot be null")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }



}
