package com.sinaukoding.taskspringboot.day3.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class GuruDto {
    private UUID id;

    @NotBlank(message = "Nama guru wajib diisi")
    private String nama;

    @NotBlank(message = "NIP guru wajib diisi")
    private Integer nip;

    @NotBlank(message = "Nomor Hp wajib diisi")
    private String nomorHp;

    private String alamat;
}
