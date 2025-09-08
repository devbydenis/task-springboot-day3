package com.sinaukoding.taskspringboot.day3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_guru", indexes = {
        @Index(name = "idx_guru_nip", columnList = "nip"),
        @Index(name = "idx_guru_created_date", columnList = "createdDate"),
        @Index(name = "idx_guru_modified_date", columnList = "modifiedDate")
})
public class Guru {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @NotBlank(message = "Nama wajib diisi")
    private String nama;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "NIP wajib diisi")
    private Integer nip;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Nomor Hp wajib diisi")
    private String nomorHp;

    private String alamat;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime modifiedDate;
}
