package com.example.juego.repository;

import com.example.juego.model.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepository extends JpaRepository<Juego, Long> {

    boolean existsByNombre(String nombre);
}
