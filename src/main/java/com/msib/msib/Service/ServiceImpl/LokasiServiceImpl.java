package com.msib.msib.Service.ServiceImpl;

import com.msib.msib.Entity.Lokasi;
import com.msib.msib.Repository.LokasiRepository;
import com.msib.msib.Service.LokasiService;
import com.msib.msib.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LokasiServiceImpl implements LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    @Autowired
    private Response response;


    @Override
    public Map add(Lokasi request) {
        Lokasi savedLokasi = lokasiRepository.save(request);
        return  response.success(savedLokasi);
    }

    @Override
    public Map update(Lokasi request) {
        Optional<Lokasi> getId = lokasiRepository.findById(request.getId());
        if (!getId.isPresent()) {
            return response.error("id not found", 404);
        }
        Lokasi lokasi = getId.get();
        lokasi.setNamaLokasi(request.getNamaLokasi());
        lokasi.setNegara(request.getNegara());
        lokasi.setProvinsi(request.getProvinsi());
        lokasi.setKota(request.getKota());
        lokasiRepository.save(lokasi);
        return response.success(lokasi);
    }

    @Override
    public Map delete(Lokasi request) {
        Optional<Lokasi> existingLokasi = lokasiRepository.findById(request.getId());
        if (existingLokasi.isPresent()){
            lokasiRepository.delete(existingLokasi.get());
            return response.success("Lokasi berhasil di hapus");
        }else {
            return  response.error("Lokasi tidak ditemukan", 404);
        }
    }

    @Override
    public Map getAllData(Lokasi request) {
        List<Lokasi> lokasiList = lokasiRepository.findAll();
        return response.success(lokasiList);
    }
}

