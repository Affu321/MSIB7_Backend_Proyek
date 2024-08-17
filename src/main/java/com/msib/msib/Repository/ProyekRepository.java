package com.msib.msib.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekRepository extends JpaRepository<ProyekRepository, Long>, JpaSpecificationExecutor<ProyekRepository> {

}
