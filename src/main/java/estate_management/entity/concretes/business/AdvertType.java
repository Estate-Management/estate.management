package estate_management.entity.concretes.business;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter

@Entity
@Table(name = "AdvertType")
public class AdvertType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false, length = 30)
    @NotNull(message = "Title cannot be null")
    @Size(max = 30, message = "Title must be less then 30 characters")
    private String title;

    @Column(name = "built_in")
    private Boolean builtIn = false;

}
