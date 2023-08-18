/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabajo.argentinapro.control;

import com.trabajo.argentinapro.entidades.Curso;
import com.trabajo.argentinapro.entidades.Estudiante;
import com.trabajo.argentinapro.entidades.Inscripcion;
import com.trabajo.argentinapro.servicios.CursoServicio;
import com.trabajo.argentinapro.servicios.EstudianteServicio;
import com.trabajo.argentinapro.servicios.InscripcionServicio;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin")
public class AdminControl {

    @Autowired
    private CursoServicio cursoServicio;
    @Autowired
    private EstudianteServicio estuServicio;
    @Autowired
    private InscripcionServicio inscServicio;

    @GetMapping("")
    public String inicio(Model model) {
        model.addAttribute("est", new Estudiante());
        model.addAttribute("listaCurso", obtenerCurso());
        model.addAttribute("listaInscripcion", obtenerInscripcion());
        return "index";
    }

    @PostMapping("/inscribir")
    public String inscribir(@ModelAttribute("est") Estudiante es, @RequestParam("id_curso") Integer id_cur) {
        Optional<Curso> curso = cursoServicio.obtener(id_cur);
        Inscripcion insc = new Inscripcion();
        insc.setCurso(curso.get());
        List<Estudiante> listaE = estuServicio.listar();
        for (Estudiante e : listaE) {
            if (es.getDni() == e.getDni()) {
                es = e;
                break;
            }
        }
        boolean existecurso = false;
        List<Inscripcion> ListaI = inscServicio.listar();
        for (Inscripcion ins : ListaI) {
            if (es.getDni() == ins.getEstudiante().getDni()) {
                if (ins.getCurso().getId_curso() == curso.get().getId_curso()) {
                    existecurso = true;
                    break;
                }
            }
        }
        if (!existecurso) {
            es = estuServicio.guardar(es);
            insc.setEstudiante(es);
            insc.setFecha_inscripcion(LocalDate.now());
            inscServicio.guardar(insc);
        }
        return "redirect:/admin";
    }

    private List<Curso> obtenerCurso() {
        return cursoServicio.listar();
    }
     private List<Inscripcion> obtenerInscripcion() {
        return inscServicio.listar();
    }

 
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        estuServicio.eliminar(id);
        return "redirect:/admin";
    }
    @GetMapping("/eliminar2/{id}")
    public String eliminar2(@PathVariable Integer id){
        inscServicio.eliminar(id);
        return "redirect:/admin";
    }    
   
    
}
