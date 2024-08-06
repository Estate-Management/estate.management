package estate_management.entity.concretes.business;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] data;
    @Column(name="name",nullable = false)
    @NotNull
    private String name;
    @Column(nullable = true)
    private String type;
    @Column(name="featured",nullable = false)
    @NotNull
    private Boolean featured=false;

    @ManyToOne
    @JoinColumn(name="advert_id",nullable = false)
    private Advert advert;
}
