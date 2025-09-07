package com.sinaukoding.taskspringboot.day3.controller;

import com.sinaukoding.taskspringboot.day3.entity.MataPelajaran;
import com.sinaukoding.taskspringboot.day3.model.dto.MataPelajaranDto;
import com.sinaukoding.taskspringboot.day3.model.record.request.MataPelajaranRequestRecord;
import com.sinaukoding.taskspringboot.day3.repository.MataPelajaranRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/mata-pelajaran")
@RequiredArgsConstructor
public class MataPelajaranController {

    private final MataPelajaranRepository mataPelajaranRepository;

    @PostMapping("add-mata-pelajaran")
    public String addStudent(@RequestBody MataPelajaranRequestRecord request) {
        var mataPelajaran = new MataPelajaran();
        mataPelajaran.setNama(request.nama());
        mataPelajaran.setDeskripsi(request.deskripsi());
        mataPelajaran.setCreatedDate(LocalDateTime.now());
        mataPelajaran.setModifiedDate(LocalDateTime.now());
        mataPelajaranRepository.save(mataPelajaran);

        return "Berhasil menambahkan meta pelajaran";
    }

    @GetMapping("list-mata-pelajaran")
    public List<MataPelajaranDto> listMataPelajaran() {
        List<MataPelajaran> listMataPelajaran = mataPelajaranRepository.findAll();
        return listMataPelajaran.stream().map(mapel -> {
            MataPelajaranDto mataPelajaranDto = new MataPelajaranDto();
            mataPelajaranDto.setId(mapel.getId());
            mataPelajaranDto.setNama(mapel.getNama());
            mataPelajaranDto.setDeskripsi(mapel.getDeskripsi());
            return mataPelajaranDto;
        }).toList();
    }

    @GetMapping("get-mata-pelajaran")
    public MataPelajaranDto  getMataPelajaran(@RequestParam Integer id) {
        var mataPelajaran = mataPelajaranRepository.findById(id).orElse(null);
        if (mataPelajaran != null) {
            MataPelajaranDto mataPelajaranDto = new MataPelajaranDto();
            mataPelajaranDto.setId(mataPelajaran.getId());
            mataPelajaranDto.setNama(mataPelajaran.getNama());
            return mataPelajaranDto;
        }
        throw new RuntimeException("Data mata pelajaran tidak ditemukan");
    }

    @PutMapping("edit-mata-pelajaran")
    public String editMataPelajaran(@RequestBody MataPelajaranRequestRecord request){
        var mataPelajaran = mataPelajaranRepository.findById(request.id()).orElse(null);
        if (mataPelajaran == null) {
            return "Mata pelajaran dengan id " + request.id() + " Tidak ditemukan";
        } else {
            mataPelajaran.setNama(request.nama());
            mataPelajaran.setDeskripsi(request.deskripsi());
            mataPelajaran.setModifiedDate(LocalDateTime.now());
            mataPelajaranRepository.save(mataPelajaran);
            return "Berhasil mengubah data";
        }
    }

    @DeleteMapping("delete-mata-pelajaran")
    public String deleteMataPelajaran(@RequestParam Integer id){
        var mataPelajaran = mataPelajaranRepository.findById(id).orElse(null);
        if (mataPelajaran == null) {
            return "Mata pelajaran dengan id " + id + "tidak ditemukan";
        } else {
            mataPelajaranRepository.deleteById(id);
            return "Berhasil menghapus mata pelajaran";
        }
    }

}
