/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.trabajo.argentinapro.interfaz;

import com.trabajo.argentinapro.entidades.Estudiante;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Sofia
 */
public interface EstudianteInterfaz {
    public Estudiante guardar(Estudiante estudiante);
    
    public void eliminar(Integer id);
    
     public Optional<Estudiante> obtener(Integer id);
    
    public List<Estudiante> listar();
            
}
