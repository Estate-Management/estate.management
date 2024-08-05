package estate_management.entity.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 150)
    private String title;

    @NotNull
    @Size(max = 50)
    private String icon;

    @NotNull
    @Column(name = "built_in")
    private boolean builtIn=false;

    @NotNull
    private int seq=0;

    @NotNull
    @Size(min = 5, max = 200)
    private String slug;
    @NotNull
    @Column(name = "is_active")
    private boolean isActive=true;

    @Column(name = "create_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd" )
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;


}
