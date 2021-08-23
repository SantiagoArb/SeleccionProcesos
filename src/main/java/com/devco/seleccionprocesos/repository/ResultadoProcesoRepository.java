package com.devco.seleccionprocesos.repository;

import com.devco.seleccionprocesos.model.ResultadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
public interface ResultadoProcesoRepository extends JpaRepository<ResultadoEntity,Long>
{
    @Modifying
    @Query(value = "select * from TBL_RESULTADO_PROCESO r where ID_PROCESO = :idProceso and r.ID_MAET_CAMPO  = (select ID_MAET_CAMPO from TBL_MAET_CAMPOS where id_etapa = :idEtapa and r.ID_MAET_CAMPO =  ID_MAET_CAMPO )",nativeQuery = true)
    Collection<ResultadoEntity> findByEtapa(@Param("idEtapa") Long idEtapa, @Param("idProceso") Long idProceso);

    @Transactional
    @Modifying
    @Query(value = "select * from tbl_resultado_proceso r where r.id_proceso = :idProceso and r.id_maet_campo = (select id_maet_campo from tbl_maet_campos m where m.id_etapa = (select  p.etapa_actual from tbl_procesos p where p.id_proceso = :idProceso ) and m.id_maet_campo = r.id_maet_campo)",nativeQuery = true)
    Collection<ResultadoEntity> validarCamposIngresados(@Param("idProceso") Long idProceso);

}
