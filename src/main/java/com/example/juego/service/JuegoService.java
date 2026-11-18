package com.example.juego.service;

import com.example.juego.model.Juego;

import java.util.List;

public interface JuegoService {

    List<Juego> listarTodos();

    Juego buscarPorId(Long id);

    Juego guardar(Juego juego);

    void eliminar(Long id);
}
