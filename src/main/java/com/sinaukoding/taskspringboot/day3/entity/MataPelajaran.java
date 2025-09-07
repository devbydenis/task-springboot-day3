package com.sinaukoding.taskspringboot.day3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_mata_pelajaran", indexes = {
        @Index(name = "idx_student_created_date", columnList = "createdDate"),
        @Index(name = "idx_student_modified_date", columnList = "modifiedDate")
})

public class MataPelajaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nama;

    private String deskripsi;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime modifiedDate;
}
