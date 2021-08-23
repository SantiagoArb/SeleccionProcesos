package com.devco.seleccionprocesos.repository;

import com.devco.seleccionprocesos.model.ProcesoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesoRepository extends JpaRepository<ProcesoEntity,Long> {
}
