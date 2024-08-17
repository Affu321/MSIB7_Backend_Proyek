package com.msib.msib.Service.ServiceImpl;

import com.msib.msib.Entity.Lokasi;
import com.msib.msib.Entity.Proyek;
import com.msib.msib.Repository.LokasiRepository;
import com.msib.msib.Repository.ProyekRepository;
import com.msib.msib.Service.LokasiService;
import com.msib.msib.Service.ProyekService;
import com.msib.msib.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProyekServiceImpl implements ProyekService {


    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private Response response;

    @Override
    public Map add(Proyek request) {
        Set<Lokasi> lokasiSet = new HashSet<>(request.getLokasi());
        request.setLokasi(lokasiSet);
        Proyek savedProyek = proyekRepository.save(request);
        return response.success(savedProyek);
    }

    @Override
    public Map update(Proyek request) {
        Optional<Proyek> getId = proyekRepository.findById(request.getId());
        if (!getId.isPresent()){
            return response.error("id not found", 404);
        }
        Proyek proyek = getId.get();
        proyek.setNamaProyek(request.getNamaProyek());
        proyek.setClient(request.getClient());
        proyek.setTglMulai(request.getTglMulai());
        proyek.setTglSelesai(request.getTglSelesai());
        proyek.setPimpinanProyek(request.getPimpinanProyek());
        proyek.setKeterangan(request.getKeterangan());
        proyek.setLokasi(new HashSet<>(request.getLokasi()));
        proyekRepository.save(proyek);
        return response.success(proyek);
    }

    @Override
    public Map delete(Proyek request) {
        Optional<Proyek> existingPrroyek = proyekRepository.findById(request.getId());
        if (existingPrroyek.isPresent()){
            proyekRepository.delete(existingPrroyek.get());
            return response.success("Proyek berhasil di hapus");
        }else {
            return  response.error("Proyek tidak ditemukan", 404);
        }
    }

    @Override
    public Map getAllData(Proyek request) {
        List<Proyek> proyekList = proyekRepository.findAll();
        return response.success(proyekList);
    }
}
