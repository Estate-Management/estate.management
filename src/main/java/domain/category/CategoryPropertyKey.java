package domain.category;

// TODO is this import needed? it is unused but if not commented out  -> error at compile time
// import estate_management.entity.concretes.business.CategoryPropertyValue;
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
@Table(name = "category_property_keys")
public class CategoryPropertyKey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 80)
    @NotNull(message = "name cannot be null")
    @Size(min = 2, max = 80, message = "Title must be between {min} and {max} characters")
    private String name;

    @Column(name = "built_in")
    private Boolean built_in=false;


    @Column(name = "category_id")
    private int categoryId;

    //TODO is it necessary or not because of categoryPropertyKeyId in the value
//    @OneToMany (mappedBy = "categoryPropertyKey")
//    private List<CategoryPropertyValue> categoryPropertyValue;


}