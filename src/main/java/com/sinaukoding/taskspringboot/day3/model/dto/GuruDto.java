package com.sinaukoding.taskspringboot.day3.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class GuruDto {
    private UUID id;
    private String nama;
    private Integer nip;
    private String nomorHp;
    private String alamat;
}
