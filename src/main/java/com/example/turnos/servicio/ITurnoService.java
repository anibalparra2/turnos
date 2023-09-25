package com.example.turnos.servicio;

import com.example.turnos.modelo.Turno;

import java.util.List;

public interface ITurnoService {

    List<Turno> generateTurnos(String fechaIni, String fechaFin, Integer idServicio);
}
