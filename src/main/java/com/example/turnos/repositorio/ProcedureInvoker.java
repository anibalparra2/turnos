package com.example.turnos.repositorio;

import com.example.turnos.modelo.Turno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@EnableJpaRepositories
@Repository
public class ProcedureInvoker {

    private final EntityManager entityManager;

    @Autowired
    public ProcedureInvoker(final EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Turno> generateTurnos(String fechaIni, String fechaFin, Integer idServicio){

        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("GENERA_TURNOS");

        // Registrar los parámetros de entrada y salida
        storedProcedureQuery.registerStoredProcedureParameter("FECHA_INI", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("FECHA_FIN", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("SERVICIO_ID", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("TURNOS_NUEVOS", Class.class, ParameterMode.REF_CURSOR);

        // Configuramos el valor de entrada
        storedProcedureQuery.setParameter("FECHA_INI", fechaIni);
        storedProcedureQuery.setParameter("FECHA_FIN", fechaFin);
        storedProcedureQuery.setParameter("SERVICIO_ID", idServicio);

        // Realizamos la llamada al procedimiento
        storedProcedureQuery.execute();

        // Obtenemos el resultado del cursor en una lista
        List<Object[]> results = storedProcedureQuery.getResultList();

        // Recorremos la lista con map y devolvemos un List<Turno>
        List<Turno> response = results.stream().map(result -> new Turno()).collect(Collectors.toList());

        return response;
    }
}
