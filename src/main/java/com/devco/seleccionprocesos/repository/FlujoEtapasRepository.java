package com.devco.seleccionprocesos.repository;

import com.devco.seleccionprocesos.model.FlujoEtapasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FlujoEtapasRepository extends JpaRepository<FlujoEtapasEntity,Long> {
}
