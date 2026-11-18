package com.example.juego.controller;

import com.example.juego.model.Juego;
import com.example.juego.service.JuegoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/juegos")
public class JuegoController {

    private final JuegoService juegoService;

    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("juegos", juegoService.listarTodos());
        return "juegos/listar";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("juego", new Juego());
        agregarListasDeApoyo(model);
        return "juegos/formulario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("juego", juegoService.buscarPorId(id));
        agregarListasDeApoyo(model);
        return "juegos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String confirmarEliminacion(@PathVariable Long id, Model model) {
        model.addAttribute("juego", juegoService.buscarPorId(id));
        return "juegos/confirmar-eliminacion";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("juego") Juego juego,
                           BindingResult resultado,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        if (resultado.hasErrors()) {
            agregarListasDeApoyo(model);
            return "juegos/formulario";
        }
        juegoService.guardar(juego);
        redirectAttributes.addFlashAttribute("mensaje", "Juego guardado correctamente.");
        return "redirect:/juegos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        juegoService.eliminar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Juego eliminado correctamente.");
        return "redirect:/juegos";
    }

    private void agregarListasDeApoyo(Model model) {
    }
}
