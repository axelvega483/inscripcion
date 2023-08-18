/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabajo.argentinapro.control;

import com.trabajo.argentinapro.entidades.Estudiante;
import com.trabajo.argentinapro.servicios.EstudianteServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sofia
 */
@Controller
@RequestMapping("estudiante")
public class EstudianteControl {

    @Autowired
    private EstudianteServicio servicio;

    @GetMapping("")
    public String Inicio(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("listaEstudiantes", obtenerEstudiante());
        return "editarEstudiante";
    }

    private List<Estudiante> obtenerEstudiante() {
        return servicio.listar();
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        servicio.eliminar(id);
        return "redirect:/estudiante";
    }

    @PostMapping("/GuardarModificacion")
    public String modificar(@ModelAttribute("estudiante") Estudiante es) {
        servicio.guardar(es);
        return "redirect:/estudiante";
    }

    @GetMapping("/editarEstudiante/{id_estudiante}")
    public String editarEstudiante(@PathVariable Integer id_estudiante, Model model) {
        Estudiante es = servicio.obtener(id_estudiante).get();
        model.addAttribute("estudiante", es);
        return "editarEstudiante";
    }
}
