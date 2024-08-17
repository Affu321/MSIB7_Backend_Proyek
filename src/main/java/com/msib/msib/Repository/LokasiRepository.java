package com.msib.msib.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.msib.msib.Entity.Lokasi;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Integer>, JpaSpecificationExecutor<Lokasi> {
}

