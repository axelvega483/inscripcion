/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabajo.argentinapro.servicios;


import com.trabajo.argentinapro.entidades.Estudiante;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trabajo.argentinapro.interfaz.EstudianteInterfaz;
import com.trabajo.argentinapro.repository.EstudianteRepo;

@Service
public class EstudianteServicio implements EstudianteInterfaz {

    @Autowired
    private EstudianteRepo repo;

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return repo.save(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Estudiante> obtener(Integer id) {
        return repo.findById(id);
    }

    @Override
    public List<Estudiante> listar() {
        return repo.findAll();
    }

}
