package com.example.juego.exception;

public class JuegoNoEncontradoException extends RuntimeException {

    public JuegoNoEncontradoException(Long id) {
        super("No se encontro el juego con id " + id);
    }
}
