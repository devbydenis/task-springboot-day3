package com.sinaukoding.taskspringboot.day3.model.record.request;

import java.util.UUID;

public record GuruRequestRecord(UUID id, String nama, Integer nip, String nomorHp, String alamat) {
}
