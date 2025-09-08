package com.sinaukoding.taskspringboot.day3.repository;

import com.sinaukoding.taskspringboot.day3.entity.Guru;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuruRepository extends JpaRepository<Guru, UUID> {
    Guru findByNip(Integer nip);
//    Guru findById(UUID id);

}
