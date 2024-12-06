package asac.hackathon.table_order.table_order.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(updatable = false)
    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    @PostPersist
    public void postPersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PostUpdate
    public void postUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


}
