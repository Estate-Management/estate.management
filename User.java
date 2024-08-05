package com.project.entity.concretes.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.entity.concretes.user.UserRole;
import jakarta.persistence.*;
import lombok.*;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, length=30)
    private String firstName;
    @Column(nullable=false, length=30)
    private String lastName;

    @Column(nullable = false, unique = true, length = 80)
    private String email;

    @Column(nullable=false)
    private String phone;


    @Column(nullable = false)
    private String passwordHash;


    @Column
    private String resetPasswordCode;

    @Column(nullable = false)
    private Boolean builtIn = false;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime create_at;

    @Column(nullable = false)
    private LocalDateTime update_at;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles;

}