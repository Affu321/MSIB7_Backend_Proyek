package com.msib.msib.Repository;

import com.msib.msib.Entity.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Integer>, JpaSpecificationExecutor<ProyekRepository> {

}
