package org.nctry.entityClass.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@ToString
@EqualsAndHashCode(of = "id")
public abstract class EntityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private  LocalDateTime updatedAt;
    @Column(name = "is_active", nullable = false, columnDefinition = "TINYINT(1) UNSIGNED DEFAULT 1")
    private boolean isActive = true;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}