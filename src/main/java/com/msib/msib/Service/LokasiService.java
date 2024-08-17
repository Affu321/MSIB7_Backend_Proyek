package com.msib.msib.Service;

import com.msib.msib.Entity.Lokasi;
import com.msib.msib.Entity.Proyek;

import java.util.Map;

public interface LokasiService {
    Map add(Lokasi request);
    Map update(Lokasi request);
    Map delete(Lokasi request);
    Map getAllData(Lokasi request);

}
