/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabajo.argentinapro.control;

import com.trabajo.argentinapro.entidades.Curso;
import com.trabajo.argentinapro.servicios.CursoServicio;
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
@RequestMapping("curso")
public class CursoControl {

    @Autowired
    private CursoServicio servicio;

    @GetMapping("")
    public String ingresoCurso(Model model) {
        model.addAttribute("curso", new Curso());
        model.addAttribute("listaCurso", obtenerCurso());
        return "RegistroCurso";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("curso") Curso curso) {
        servicio.guardar(curso);
        return "redirect:/curso";
    }

    private List<Curso> obtenerCurso() {
        return servicio.listar();
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        servicio.eliminar(id);
        return "redirect:/curso";
    }

    @PostMapping("/GuardarModificacion1")
    public String modificar(@ModelAttribute("curso") Curso cur) {
        servicio.guardar(cur);
        return "redirect:/curso";
    }

    @GetMapping("/editar/{id_curso}")
    public String editar(@PathVariable Integer id_curso, Model model) {
        Curso cur = servicio.obtener(id_curso).get();
        model.addAttribute("curso", cur);
        return "editarCurso";
    }
}
