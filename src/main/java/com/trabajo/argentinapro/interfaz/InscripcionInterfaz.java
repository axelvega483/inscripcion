/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.trabajo.argentinapro.interfaz;

import com.trabajo.argentinapro.entidades.Inscripcion;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Sofia
 */
public interface InscripcionInterfaz {
    public Inscripcion guardar(Inscripcion inscripcion);
    
    public void eliminar(Integer id);
    
     public Optional<Inscripcion> obtener(Integer id);
    
    public List<Inscripcion> listar();
}
