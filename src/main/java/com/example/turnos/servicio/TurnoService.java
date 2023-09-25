package com.example.turnos.servicio;

import com.example.turnos.modelo.Turno;
import com.example.turnos.repositorio.ITurnoRepository;
import com.example.turnos.repositorio.ProcedureInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    private ProcedureInvoker procedureRepository;

    public List<Turno> generateTurnos(String fechaIni, String fechaFin, Integer idServicio){
        return turnoRepository.generateTurnos(fechaIni, fechaFin, idServicio);
    }

    public List<Turno> generateTurnos2(String fechaIni, String fechaFin, Integer idServicio){
        return procedureRepository.generateTurnos(fechaIni,fechaFin,idServicio);
    }
}
