/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabajo.argentinapro.servicios;

import com.trabajo.argentinapro.entidades.Curso;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trabajo.argentinapro.interfaz.CursoInterfaz;
import com.trabajo.argentinapro.repository.CursoRepo;

/**
 *
 * @author Sofia
 */
@Service 
public class CursoServicio implements CursoInterfaz{
    @Autowired
    private CursoRepo repo;
    
    @Override
    public Curso guardar(Curso curso) {
        return repo.save(curso);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Curso> obtener(Integer id) {
        return repo.findById(id);
    }

    @Override
    public List<Curso> listar() {
        return repo.findAll();
    }
    
}
