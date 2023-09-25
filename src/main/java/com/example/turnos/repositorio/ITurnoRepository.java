package com.example.turnos.repositorio;

import com.example.turnos.modelo.Turno;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ITurnoRepository extends JpaRepository<Turno,String> {

    @Modifying
    @Query(value="{ call GENERA_TURNOS(:fechaIni, :fechaFin, :idServicio) }", nativeQuery = true)
    @Transactional
    List<Turno> generateTurnos(String fechaIni, String fechaFin, Integer idServicio);
}
