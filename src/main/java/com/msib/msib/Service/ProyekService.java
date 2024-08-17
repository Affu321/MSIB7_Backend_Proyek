package com.msib.msib.Service;

import com.msib.msib.Entity.Proyek;

import java.util.Map;

public interface ProyekService {
    Map add(Proyek request);
    Map update(Proyek request);
    Map delete(Proyek request);
    Map getAllData(Proyek request);
}
