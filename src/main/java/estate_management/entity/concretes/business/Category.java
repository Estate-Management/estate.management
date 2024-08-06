package estate_management.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 150)
    @NotNull(message = "Title cannot be null")
    @Size(max=150 ,message = "Title must be less then 150 characters")
    private String title;

    @Column(name = "icon", nullable = false, length = 50)
    @NotNull(message = "icon cannot be null")
    @Size(max=50 ,message = "icon must be less then 50 characters")
    private String icon;

    @Column(name = "built_in",nullable = false)
    @NotNull(message = "built_in cannot be null")
    private boolean builtIn=false;

    @Column(name = "seq",nullable = false)
    @NotNull(message = "seq cannot be null")
    private int seq=0;

    @Column(name = "slug", length = 200,nullable = false)
    @NotNull(message = "slug cannot be null")
    @Size(min = 5, max = 200)
    private String slug;

    @Column(name = "isActive",nullable = false)
    @NotNull(message = "slug cannot be null")
    private Boolean isActive=true;

    @OneToMany(mappedBy = "category")
    private List<CategoryPropertyKeys> categoryPropertyKeys;


    @Column(name = "create_at",nullable = false)
    @NotNull(message = "createAt cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime create_at;

    @Column(name = "updateAt",nullable = false)
    @NotNull(message = "updateAt cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime update_at;






    @PrePersist
    private void onCreate() {
        create_at = LocalDateTime.now();
        update_at = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        update_at = LocalDateTime.now();
    }
}


