package estate_management.entitiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.Category;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.regex.Pattern;


@Data
@Entity
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false, length = 150)
    @NotNull(message = "Title cannot be null")
    @Size(min = 5, max = 150, message = "Title must be between 5 and 150 characters")
    private String title;

    @Column(name = "desc",length = 300)
    @Size(max = 300, message = "Description can contain maximum 300 characters")
    private String desc;

    // what should it mean "title with url encoded"
    @Column(name = "slug", nullable = false, length = 200)
    @NotNull(message = "Slug cannot be null")
    @Size(min = 5, max = 200)
    private String slug;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    @Column(name = "status", nullable = false)
    @NotNull(message = "Status cannot be null, default 0")
    private Integer status = 0;

    // Have an issue here, documentation given type should be boolean but default value shoudl be 0.
    @Column(name = "built_in", nullable = false)
    @NotNull()
    private boolean builtIn;

    @Column(name = "is_active", nullable = false)
    @NotNull(message = "Can not be null")
    private boolean isActive = true;

    @Column(name = "view_count", nullable = false)
    @NotNull
    private int viewCount = 0;

    // Google embeded code should be stored in this field.
    @Column(name = "location", nullable = false)
    @NotNull(message = "Location cannot be null")
    private String location;

    @Column(name = "create_at", nullable = false)
    @NotNull(message = "Create cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime updatedAt;



    // FOREIGN KEY FIELDS
    @ManyToOne
    @NotNull
    @JoinColumn(name = "advert_type_id", nullable = false)
    private AdvertType advertType;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;





    // ------ METHODS --------

    //Method to convert input String (title) to slug
    public static String toSlug(String input) {
        String noWhiteSpace = Pattern.compile("\\s").matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(noWhiteSpace, Normalizer.Form.NFD);
        String slug = Pattern.compile("[^\\w-]").matcher(normalized).replaceAll("");
        return slug.toLowerCase();
    }

    /*
    Methode to generate and prePersist/preUpdate slug field from title automatically.
    Creation time prePersist to current time if not set manually.
    PreUpdate updatedAt field.
    */
    @PrePersist
    @PreUpdate
    public void prePersistEntity() {
        this.slug = toSlug(this.title);
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        this.updatedAt = LocalDateTime.now();
    }

}
