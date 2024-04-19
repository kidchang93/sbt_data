package com.example.testprogect.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate        // 엔티티가 저장되는 시점에 자동으로 시간을 주입
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate   // 엔티티가 수정되는 시점에 자동으로 시간을 주입 (주체를 주입할때는 LastModifiedBy 애너테이션)
    private LocalDateTime updatedAt;
}
