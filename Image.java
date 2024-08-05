package com.project.entity.concretes;

import jakarta.persistence.*;

@Entity
@Table(name="images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    private byte[] data;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String type;
    @Column(nullable = false)
    private Boolean featured;

    @ManyToOne
    @JoinColumn(name="advert_id",nullable = false)
    private Advert advert;

}
