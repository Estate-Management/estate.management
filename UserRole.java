package com.project.entity.concretes.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="user_roles")

public class UserRole {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private com.project.entity.concretes.users.User user;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
}
