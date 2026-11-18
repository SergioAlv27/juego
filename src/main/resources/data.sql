-- Script de datos de ejemplo (10 registros) para la tabla 'juego'
-- INSERT IGNORE evita errores de nombre duplicado si la app se reinicia

INSERT IGNORE INTO juego (nombre, desarrollador, tamano_gb, anio_creacion) VALUES
('The Witcher 3',          'CD Projekt Red',      50.00, 2015),
('Red Dead Redemption 2',  'Rockstar Games',     150.00, 2018),
('Minecraft',              'Mojang Studios',       1.50, 2011),
('Grand Theft Auto V',     'Rockstar Games',     110.00, 2013),
('Elden Ring',             'FromSoftware',        60.00, 2022),
('Fortnite',               'Epic Games',          30.00, 2017),
('Hollow Knight',          'Team Cherry',          9.00, 2017),
('Cyberpunk 2077',         'CD Projekt Red',      70.00, 2020),
('League of Legends',      'Riot Games',          22.00, 2009),
('Baldur''s Gate 3',       'Larian Studios',     150.00, 2023);
