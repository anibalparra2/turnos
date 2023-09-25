package com.example.turnos.servicio;

import com.example.turnos.modelo.Comercio;
import com.example.turnos.repositorio.IComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercioService implements IComercioService{

    @Autowired
    private IComercioRepository comercioRepository;

    @Override
    public List<Comercio> findAll() {
        return comercioRepository.findAll();
    }
}
