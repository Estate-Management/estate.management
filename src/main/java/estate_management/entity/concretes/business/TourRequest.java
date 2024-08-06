package estate_management.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter

@Entity
@Table(name = "TourRequest")
public class TourRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tour_date", nullable = false)
    @NotNull(message = "The tour date can not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime tourDate;

    @Column(name = "tour_time", nullable = false)
    @NotNull(message = "The tourTime can not be null")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalDateTime tourTime;

    @Column(name ="status",nullable = false)
    @NotNull(message = "status cant be null")
    private int status = 0;



    @ManyToOne
    @JoinColumn(name = "advert_id", nullable = false)
    @NotNull(message = "advert cant be null")
    private Advert advert;

    @ManyToOne
    @JoinColumn(name = "owner_user_id", nullable = false)
    @NotNull(message = "ownerUserId cant be null")
    private User ownerUserId;

    @ManyToOne
    @JoinColumn(name = "guest_user_id", nullable = false)
    @NotNull(message = "guestUserId cant be null")
    private User guestUserId;

    @Column(name = "create_at", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @NotNull(message = "createAt cant be null")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @NotNull(message = "updateAt cant be null")
    private LocalDateTime updateAt;

}
