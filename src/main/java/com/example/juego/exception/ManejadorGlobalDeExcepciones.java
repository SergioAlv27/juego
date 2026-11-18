package com.example.juego.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ManejadorGlobalDeExcepciones {

    @ExceptionHandler(JuegoNoEncontradoException.class)
    public String manejarJuegoNoEncontrado(JuegoNoEncontradoException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:/juegos";
    }
}
