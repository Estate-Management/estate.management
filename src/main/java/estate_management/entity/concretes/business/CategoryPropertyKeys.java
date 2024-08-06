package estate_management.entity.concretes.business;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter

@Entity
@Table(name = "CategoryPropertyKeys")
public class CategoryPropertyKeys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 80)
    @NotNull(message = "name cannot be null")
    @Size(min = 2, max = 80, message = "Title must be between 2 and 80 characters")
    private String name;

    @Column(name = "built_in", nullable = false)
    @NotNull()
    private Boolean builtIn=false;


    @ManyToOne
    @NotNull
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnore
    private Category category;

   @OneToMany (mappedBy = "categoryPropertyKey")
    private List<CategoryPropertyValue> categoryPropertyValue;


}