package estate_management.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="log_name", nullable = false, length= 30)
    @NotNull(message = "Log cannot be null")
    @Size(max = 30)
    private String name;

    @ManyToOne()
    @JoinColumn(name="log_id")
    @JsonIgnore
    private User user;;

    @ManyToOne
    private  Advert advert;

    @Column(name = "created_at", nullable = false)
    @NotNull(message = "Creation time cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }



}
