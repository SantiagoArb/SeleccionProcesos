package com.devco.seleccionprocesos.repository;

import com.devco.seleccionprocesos.model.CandidatosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatosRepository extends JpaRepository<CandidatosEntity,Long> {

}
