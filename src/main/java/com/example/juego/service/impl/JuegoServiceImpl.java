package com.example.juego.service.impl;

import com.example.juego.exception.JuegoNoEncontradoException;
import com.example.juego.model.Juego;
import com.example.juego.repository.JuegoRepository;
import com.example.juego.service.JuegoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JuegoServiceImpl implements JuegoService {

    private final JuegoRepository juegoRepository;

    public JuegoServiceImpl(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Juego> listarTodos() {
        return juegoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Juego buscarPorId(Long id) {
        return juegoRepository.findById(id)
                .orElseThrow(() -> new JuegoNoEncontradoException(id));
    }

    @Override
    public Juego guardar(Juego juego) {
        return juegoRepository.save(juego);
    }

    @Override
    public void eliminar(Long id) {
        if (!juegoRepository.existsById(id)) {
            throw new JuegoNoEncontradoException(id);
        }
        juegoRepository.deleteById(id);
    }
}
