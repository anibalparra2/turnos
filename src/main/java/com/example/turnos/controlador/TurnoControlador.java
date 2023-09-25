package com.example.turnos.controlador;

import com.example.turnos.modelo.Comercio;
import com.example.turnos.modelo.RequestTurno;
import com.example.turnos.modelo.Turno;
import com.example.turnos.servicio.ComercioService;
import com.example.turnos.servicio.TurnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turnos-app")
@CrossOrigin(value = "http://192.168.0.10:4200")
public class TurnoControlador {

    private static final Logger logger = LoggerFactory.getLogger(TurnoControlador.class);

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private ComercioService comercioService;

    @PostMapping("/generar")
    public List<Turno> generarTurnos(@RequestBody RequestTurno requestTurno){
        logger.info("RequestTurno: " + requestTurno);
        List<Turno> turnos = turnoService.generateTurnos2
                (requestTurno.getFechaIni(),requestTurno.getFechaFin(),requestTurno.getIdServicio());
        turnos.forEach(turno -> logger.info("ID: " + turno.getIdTurno()));
        return turnos;
    }

    @GetMapping("/comercios")
    public List<Comercio> getComercios(){
        List<Comercio> comercios = comercioService.findAll();
        return comercios;
    }

}
