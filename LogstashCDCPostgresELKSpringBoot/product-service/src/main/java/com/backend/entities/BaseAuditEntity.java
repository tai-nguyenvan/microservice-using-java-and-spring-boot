package com.backend.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseAuditEntity extends BaseEntity implements Serializable {

    private String createdBy;

    @CreationTimestamp
    private Instant createdAt;

    private String updatedBy;

    @UpdateTimestamp
    private Instant updatedAt;

    @PrePersist
    public void onPrePersist() {
        this.createdAt = Instant.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseAuditEntity that = (BaseAuditEntity) o;
        return Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedBy, that.updatedBy) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy, createdAt, updatedBy, updatedAt);
    }

    @Override
    public String toString() {
        return "BaseAuditEntity{" +
                "createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
