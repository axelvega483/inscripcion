/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.trabajo.argentinapro.interfaz;

import com.trabajo.argentinapro.entidades.Curso;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Sofia
 */
public interface CursoInterfaz {
    
    public Curso guardar(Curso curso);
    
    public void eliminar(Integer id);
    
     public Optional<Curso> obtener(Integer id);
    
    public List<Curso> listar();
}
