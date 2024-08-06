package estate_management.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "CategoryPropertyValue")
public class CategoryPropertyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", nullable = false, length = 100)
    @NotNull(message = "value cannot be null")
    @Size( max = 100, message = "value must beless then 100 characters")
    private String value;


    @ManyToOne
    @JoinColumn(name = "advert_id")
    @JsonIgnore
    private Advert advert;

    @ManyToOne
    @JoinColumn(name = "category_property_key_id")
    @JsonIgnore
    private CategoryPropertyKeys categoryPropertyKey;

}
