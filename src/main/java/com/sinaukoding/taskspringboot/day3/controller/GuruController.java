package com.sinaukoding.taskspringboot.day3.controller;

import com.sinaukoding.taskspringboot.day3.entity.Guru;
import com.sinaukoding.taskspringboot.day3.model.dto.GuruDto;
import com.sinaukoding.taskspringboot.day3.model.record.request.GuruRequestRecord;
import com.sinaukoding.taskspringboot.day3.repository.GuruRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/guru")
@RequiredArgsConstructor
public class GuruController {

    private final GuruRepository guruRepository;

    @PostMapping("add-guru")
    public String addGuru(@RequestBody GuruRequestRecord request){
        var currentGuru = guruRepository.findByNip(request.nip());
        if (currentGuru != null) {
            return "Data dengan NIP: " + " sudah ada";
        }

        var guru = new Guru();
        guru.setNama(request.nama());
        guru.setNip(request.nip());
        guru.setNomorHp(request.nomorHp());
        guru.setAlamat(request.alamat());
        guru.setCreatedDate(LocalDateTime.now());
        guru.setModifiedDate(LocalDateTime.now());
        guruRepository.save(guru);

        return "Berhasil menambahkan guru ke daftar guru";
    }

    @GetMapping("list-guru")
    public List<GuruDto> listGuru() {
        List<Guru> listGuru = guruRepository.findAll();
        return listGuru.stream().map(guru -> {
            GuruDto guruDto = new GuruDto();
            guruDto.setId(guru.getId());
            guruDto.setNama(guru.getNama());
            guruDto.setNip(guru.getNip());
            guruDto.setNomorHp(guru.getNomorHp());
            guruDto.setAlamat(guru.getAlamat());
            return guruDto;
        }).toList();
    }

    @GetMapping("get-guru")
    public GuruDto getGuru(@RequestParam UUID id) {
        var guru = guruRepository.findById(id).orElse(null);
        if (guru != null) {
            GuruDto guruDto = new GuruDto();
            guruDto.setId(guru.getId());
            guruDto.setNama(guru.getNama());
            guruDto.setNip(guru.getNip());
            guruDto.setNomorHp(guru.getNomorHp());
            guruDto.setAlamat(guru.getAlamat());
            return guruDto;
        }
        throw new RuntimeException("Data guru tidak ditemukan!");
    }

    @PutMapping("edit-guru")
    public String editGuru(@RequestBody GuruRequestRecord request){
        var guru = guruRepository.findById(request.id()).orElse(null);
        if (guru != null) {
            guru.setNama(
                    request.nama() == null
                        ? guru.getNama()
                            : request.nama()
            );
            guru.setNip(
                    request.nip() == null
                        ? guru.getNip()
                            : request.nip()
            );
            guru.setNomorHp(
                    request.nomorHp() == null
                        ? guru.getNomorHp()
                            : request.nomorHp()
            );
            guru.setNip(
                    request.nip() == null
                        ? guru.getNip()
                            : request.nip()
            );
            guru.setAlamat(
                    request.alamat() == null
                        ? guru.getAlamat()
                            : request.alamat()
            );
            guru.setModifiedDate(LocalDateTime.now());
            guruRepository.save(guru);
            return "Berhasil mengubah data";
        }
        return "Guru dengan id " + request.id() + " tidak ditemukan";
    }

    @DeleteMapping("delete-guru")
    public String deleteGuru(@RequestParam UUID id) {
        var guru = guruRepository.findById(id).orElse(null);
        if (guru != null) {
            guruRepository.deleteById(id);
            return "Berhasil menghapus data guru dengan id" + id;
        }
        return "Guru dengan id " + id + "tidak ditemukan";
    }
}
