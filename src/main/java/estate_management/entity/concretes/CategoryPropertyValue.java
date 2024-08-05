package estate_management.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryPropertyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String value;

    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;

    @ManyToOne
    @JoinColumn(name = "category+property_key_id")
    private CategoryPropertyKey categoryPropertyKey;


}
