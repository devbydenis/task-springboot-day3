package com.sinaukoding.taskspringboot.day3.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class KelasDto {
    private Integer id;

    @NotBlank(message = "Nama kelas wajib diisi")
    private String nama;

    private String deskripsi;

    @Min(value = 1, message = "Kapasitas kelas harus lebih dari 1")
    private Integer kapasitas;
}
