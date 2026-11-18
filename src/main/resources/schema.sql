-- Script de creacion de la tabla 'juego'
-- La base de datos 'juego_db' se crea automaticamente por el driver JDBC
-- (parametro createDatabaseIfNotExist=true en application.properties)

CREATE TABLE IF NOT EXISTS juego (
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre         VARCHAR(80)   NOT NULL UNIQUE,
    desarrollador  VARCHAR(60)   NOT NULL,
    tamano_gb      DECIMAL(6,2)  NOT NULL,
    anio_creacion  INT           NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
