/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabajo.argentinapro.servicios;

import com.trabajo.argentinapro.entidades.Inscripcion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trabajo.argentinapro.interfaz.InscripcionInterfaz;
import com.trabajo.argentinapro.repository.InscripcionRepo;

/**
 *
 * @author Sofia
 */
@Service 
public class InscripcionServicio implements InscripcionInterfaz {
    @Autowired
    private InscripcionRepo repo;
    
    @Override
    public Inscripcion guardar(Inscripcion inscripcion) {
        return repo.save(inscripcion);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Inscripcion> obtener(Integer id) {
        return repo.findById(id);
    }

    @Override
    public List<Inscripcion> listar() {
        return repo.findAll();
    }
    
}
