package org.nctry.server.user.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(of = "id")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) // Reference to the UserFullData table
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private UserFulldata userFullData;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "last_online_at", nullable = false)
    private LocalDateTime lastOnlineAt;

    @PrePersist
    protected void onCreate(){
        this.lastOnlineAt = LocalDateTime.now();
    }
}

