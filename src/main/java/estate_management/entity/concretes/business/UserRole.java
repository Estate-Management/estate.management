package estate_management.entity.concretes.business;


import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)

@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //bunu anlamadim
    @ManyToOne
    private User user;
}
