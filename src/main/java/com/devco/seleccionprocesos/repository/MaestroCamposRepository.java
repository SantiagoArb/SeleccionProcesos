package com.devco.seleccionprocesos.repository;

import com.devco.seleccionprocesos.model.MaestroCamposEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MaestroCamposRepository extends JpaRepository<MaestroCamposEntity,Long> {

    @Modifying
    @Transactional
    @Query(value = "select count(*) from tbl_maet_campos m where m.id_etapa=?1", nativeQuery = true)
    Integer contarCamposPorEtapa(Long idEtapa);

    Long countByidEtapa(Long idEtapa);
}
