package com.example.turnos.repositorio;

import com.example.turnos.modelo.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IComercioRepository extends JpaRepository<Comercio, Integer> {

    List<Comercio> findAll();

}
