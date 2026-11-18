package com.example.juego.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "juego")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 80, message = "El nombre no puede superar los 80 caracteres")
    @Column(name = "nombre", nullable = false, unique = true, length = 80)
    private String nombre;

    @NotBlank(message = "El desarrollador es obligatorio")
    @Size(max = 60, message = "El desarrollador no puede superar los 60 caracteres")
    @Column(name = "desarrollador", nullable = false, length = 60)
    private String desarrollador;

    @NotNull(message = "El tamano es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El tamano debe ser mayor que 0")
    @Column(name = "tamano_gb", nullable = false, precision = 6, scale = 2)
    private BigDecimal tamanoGb;

    @NotNull(message = "El anio de creacion es obligatorio")
    @Min(value = 1950, message = "El anio de creacion no es valido")
    @Max(value = 2100, message = "El anio de creacion no es valido")
    @Column(name = "anio_creacion", nullable = false)
    private Integer anioCreacion;

    public Juego() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public BigDecimal getTamanoGb() {
        return tamanoGb;
    }

    public void setTamanoGb(BigDecimal tamanoGb) {
        this.tamanoGb = tamanoGb;
    }

    public Integer getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(Integer anioCreacion) {
        this.anioCreacion = anioCreacion;
    }
}
