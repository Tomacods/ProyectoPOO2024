-- Preguntas de deporte
INSERT INTO Pregunta_multiple_choise (Enunciado, Categoria, ID_Tematica) VALUES
('¿Cuál es el país con más Copas del Mundo ganadas en fútbol?', 'deporte', 1),
('¿En qué año se celebraron los primeros Juegos Olímpicos modernos?', 'deporte', 1),
('¿Quién es el máximo goleador de la historia de la NBA?', 'deporte', 1),
('¿Cuál es el deporte nacional de Japón?', 'deporte', 1),
('¿Cuántos jugadores hay en un equipo de rugby?', 'deporte', 1),
('¿Cuál es el torneo de tenis más antiguo del mundo?', 'deporte', 1),
('¿En qué deporte se utiliza el término "home run"?', 'deporte', 1),
('¿Quién ha ganado más títulos de Grand Slam en tenis?', 'deporte', 1),
('¿Cuál es el récord mundial de los 100 metros planos?', 'deporte', 1),
('¿Qué país ganó la Copa del Mundo de Rugby en 2019?', 'deporte', 1);

-- Respuestas para las preguntas de deporte
INSERT INTO Respuesta (ID_Pregunta, Texto, Correcta) VALUES
(1, 'Brasil', TRUE),
(1, 'Alemania', FALSE),
(1, 'Italia', FALSE),
(1, 'Argentina', FALSE),

(2, '1896', TRUE),
(2, '1900', FALSE),
(2, '1912', FALSE),
(2, '1920', FALSE),

(3, 'Kareem Abdul-Jabbar', TRUE),
(3, 'Michael Jordan', FALSE),
(3, 'LeBron James', FALSE),
(3, 'Kobe Bryant', FALSE),

(4, 'Sumo', TRUE),
(4, 'Judo', FALSE),
(4, 'Karate', FALSE),
(4, 'Kendo', FALSE),

(5, '15', TRUE),
(5, '11', FALSE),
(5, '13', FALSE),
(5, '7', FALSE),

(6, 'Wimbledon', TRUE),
(6, 'Roland Garros', FALSE),
(6, 'US Open', FALSE),
(6, 'Australian Open', FALSE),

(7, 'Béisbol', TRUE),
(7, 'Críquet', FALSE),
(7, 'Fútbol americano', FALSE),
(7, 'Hockey', FALSE),

(8, 'Roger Federer', TRUE),
(8, 'Rafael Nadal', FALSE),
(8, 'Novak Djokovic', FALSE),
(8, 'Pete Sampras', FALSE),

(9, '9.58 segundos', TRUE),
(9, '9.69 segundos', FALSE),
(9, '9.72 segundos', FALSE),
(9, '9.74 segundos', FALSE),

(10, 'Sudáfrica', TRUE),
(10, 'Inglaterra', FALSE),
(10, 'Nueva Zelanda', FALSE),
(10, 'Australia', FALSE);


-- Preguntas de arte
INSERT INTO Pregunta_multiple_choise (Enunciado, Categoria, ID_Tematica) VALUES
('¿Quién pintó la Mona Lisa?', 'arte', 2),
('¿En qué museo se encuentra la Mona Lisa?', 'arte', 2),
('¿Quién es el autor de "La noche estrellada"?', 'arte', 2),
('¿Cuál es el estilo artístico de Pablo Picasso?', 'arte', 2),
('¿En qué país nació Frida Kahlo?', 'arte', 2),
('¿Qué movimiento artístico lideró Salvador Dalí?', 'arte', 2),
('¿Quién esculpió "El David"?', 'arte', 2),
('¿Cuál es la técnica principal de Jackson Pollock?', 'arte', 2),
('¿En qué ciudad se encuentra el Museo del Prado?', 'arte', 2),
('¿Quién pintó "La última cena"?', 'arte', 2);

-- Respuestas para las preguntas de arte
INSERT INTO Respuesta (ID_Pregunta, Texto, Correcta) VALUES
(11, 'Leonardo da Vinci', TRUE),
(11, 'Vincent van Gogh', FALSE),
(11, 'Pablo Picasso', FALSE),
(11, 'Claude Monet', FALSE),

(12, 'Museo del Louvre', TRUE),
(12, 'Museo del Prado', FALSE),
(12, 'Museo de Arte Moderno', FALSE),
(12, 'Museo Británico', FALSE),

(13, 'Vincent van Gogh', TRUE),
(13, 'Claude Monet', FALSE),
(13, 'Pablo Picasso', FALSE),
(13, 'Salvador Dalí', FALSE),

(14, 'Cubismo', TRUE),
(14, 'Impresionismo', FALSE),
(14, 'Surrealismo', FALSE),
(14, 'Expresionismo', FALSE),

(15, 'México', TRUE),
(15, 'España', FALSE),
(15, 'Italia', FALSE),
(15, 'Francia', FALSE),

(16, 'Surrealismo', TRUE),
(16, 'Cubismo', FALSE),
(16, 'Impresionismo', FALSE),
(16, 'Expresionismo', FALSE),

(17, 'Miguel Ángel', TRUE),
(17, 'Donatello', FALSE),
(17, 'Bernini', FALSE),
(17, 'Rodin', FALSE),

(18, 'Dripping', TRUE),
(18, 'Cubismo', FALSE),
(18, 'Impresionismo', FALSE),
(18, 'Surrealismo', FALSE),

(19, 'Madrid', TRUE),
(19, 'Barcelona', FALSE),
(19, 'París', FALSE),
(19, 'Roma', FALSE),

(20, 'Leonardo da Vinci', TRUE),
(20, 'Miguel Ángel', FALSE),
(20, 'Rafael', FALSE),
(20, 'Donatello', FALSE);


-- Preguntas de historia
INSERT INTO Pregunta_multiple_choise (Enunciado, Categoria, ID_Tematica) VALUES
('¿En qué año comenzó la Segunda Guerra Mundial?', 'historia', 3),
('¿Quién fue el primer presidente de los Estados Unidos?', 'historia', 3),
('¿Qué imperio construyó la Gran Muralla China?', 'historia', 3),
('¿En qué año cayó el Muro de Berlín?', 'historia', 3),
('¿Quién descubrió América?', 'historia', 3),
('¿Cuál fue la primera civilización en usar la escritura?', 'historia', 3),
('¿Quién fue el líder de la Revolución Rusa de 1917?', 'historia', 3),
('¿En qué año se firmó la Declaración de Independencia de los Estados Unidos?', 'historia', 3),
('¿Quién fue el faraón más famoso de Egipto?', 'historia', 3),
('¿En qué año se fundó Roma?', 'historia', 3);

-- Respuestas para las preguntas de historia
INSERT INTO Respuesta (ID_Pregunta, Texto, Correcta) VALUES
(21, '1939', TRUE),
(21, '1941', FALSE),
(21, '1938', FALSE),
(21, '1940', FALSE),

(22, 'George Washington', TRUE),
(22, 'Thomas Jefferson', FALSE),
(22, 'Abraham Lincoln', FALSE),
(22, 'John Adams', FALSE),

(23, 'Imperio Chino', TRUE),
(23, 'Imperio Mongol', FALSE),
(23, 'Imperio Japonés', FALSE),
(23, 'Imperio Persa', FALSE),

(24, '1989', TRUE),
(24, '1990', FALSE),
(24, '1988', FALSE),
(24, '1991', FALSE),

(25, 'Cristóbal Colón', TRUE),
(25, 'Américo Vespucio', FALSE),
(25, 'Fernando de Magallanes', FALSE),
(25, 'Hernán Cortés', FALSE),

(26, 'Sumerios', TRUE),
(26, 'Egipcios', FALSE),
(26, 'Babilonios', FALSE),
(26, 'Asirios', FALSE),

(27, 'Vladimir Lenin', TRUE),
(27, 'Joseph Stalin', FALSE),
(27, 'Leon Trotsky', FALSE),
(27, 'Nikolai Bukharin', FALSE),

(28, '1776', TRUE),
(28, '1783', FALSE),
(28, '1775', FALSE),
(28, '1781', FALSE),

(29, 'Tutankamón', TRUE),
(29, 'Ramsés II', FALSE),
(29, 'Cleopatra', FALSE),
(29, 'Akhenatón', FALSE),

(30, '753 a.C.', TRUE),
(30, '509 a.C.', FALSE),
(30, '476 d.C.', FALSE),
(30, '27 a.C.', FALSE);



-- Preguntas de ciencia
INSERT INTO Pregunta_multiple_choise (Enunciado, Categoria, ID_Tematica) VALUES
('¿Cuál es la fórmula química del agua?', 'ciencia', 4),
('¿Quién propuso la teoría de la relatividad?', 'ciencia', 4),
('¿Cuál es el planeta más grande del sistema solar?', 'ciencia', 4),
('¿Qué partícula subatómica tiene carga negativa?', 'ciencia', 4),
('¿Cuál es la velocidad de la luz en el vacío?', 'ciencia', 4),
('¿Qué gas es esencial para la respiración humana?', 'ciencia', 4),
('¿Quién es conocido como el padre de la genética?', 'ciencia', 4),
('¿Cuál es el elemento más abundante en el universo?', 'ciencia', 4),
('¿Qué científico descubrió la penicilina?', 'ciencia', 4),
('¿Cuál es la unidad de medida de la fuerza?', 'ciencia', 4);

-- Respuestas para las preguntas de ciencia
INSERT INTO Respuesta (ID_Pregunta, Texto, Correcta) VALUES
(31, 'H2O', TRUE),
(31, 'CO2', FALSE),
(31, 'O2', FALSE),
(31, 'N2', FALSE),

(32, 'Albert Einstein', TRUE),
(32, 'Isaac Newton', FALSE),
(32, 'Galileo Galilei', FALSE),
(32, 'Nikola Tesla', FALSE),

(33, 'Júpiter', TRUE),
(33, 'Saturno', FALSE),
(33, 'Urano', FALSE),
(33, 'Neptuno', FALSE),

(34, 'Electrón', TRUE),
(34, 'Protón', FALSE),
(34, 'Neutrón', FALSE),
(34, 'Quark', FALSE),

(35, '299,792,458 m/s', TRUE),
(35, '150,000,000 m/s', FALSE),
(35, '3,000,000 m/s', FALSE),
(35, '30,000,000 m/s', FALSE),

(36, 'Oxígeno', TRUE),
(36, 'Nitrógeno', FALSE),
(36, 'Dióxido de carbono', FALSE),
(36, 'Hidrógeno', FALSE),

(37, 'Gregor Mendel', TRUE),
(37, 'Charles Darwin', FALSE),
(37, 'Louis Pasteur', FALSE),
(37, 'James Watson', FALSE),

(38, 'Hidrógeno', TRUE),
(38, 'Helio', FALSE),
(38, 'Oxígeno', FALSE),
(38, 'Carbono', FALSE),

(39, 'Alexander Fleming', TRUE),
(39, 'Louis Pasteur', FALSE),
(39, 'Robert Koch', FALSE),
(39, 'Edward Jenner', FALSE),

(40, 'Newton', TRUE),
(40, 'Joule', FALSE),
(40, 'Watt', FALSE),
(40, 'Pascal', FALSE);


-- Preguntas de geografía
INSERT INTO Pregunta_multiple_choise (Enunciado, Categoria, ID_Tematica) VALUES
('¿Cuál es el río más largo del mundo?', 'geografía', 5),
('¿En qué continente se encuentra el desierto del Sahara?', 'geografía', 5),
('¿Cuál es la capital de Australia?', 'geografía', 5),
('¿Qué país tiene la mayor cantidad de islas en el mundo?', 'geografía', 5),
('¿Cuál es el país más grande del mundo por superficie?', 'geografía', 5),
('¿En qué océano se encuentra la Fosa de las Marianas?', 'geografía', 5),
('¿Cuál es la montaña más alta del mundo?', 'geografía', 5),
('¿Qué país tiene la mayor población del mundo?', 'geografía', 5),
('¿Cuál es el lago más grande del mundo por superficie?', 'geografía', 5),
('¿En qué país se encuentra la ciudad de Petra?', 'geografía', 5);

-- Respuestas para las preguntas de geografía
INSERT INTO Respuesta (ID_Pregunta, Texto, Correcta) VALUES
(41, 'Amazonas', TRUE),
(41, 'Nilo', FALSE),
(41, 'Yangtsé', FALSE),
(41, 'Misisipi', FALSE),

(42, 'África', TRUE),
(42, 'Asia', FALSE),
(42, 'América del Sur', FALSE),
(42, 'Oceanía', FALSE),

(43, 'Canberra', TRUE),
(43, 'Sídney', FALSE),
(43, 'Melbourne', FALSE),
(43, 'Brisbane', FALSE),

(44, 'Suecia', TRUE),
(44, 'Noruega', FALSE),
(44, 'Indonesia', FALSE),
(44, 'Filipinas', FALSE),

(45, 'Rusia', TRUE),
(45, 'Canadá', FALSE),
(45, 'China', FALSE),
(45, 'Estados Unidos', FALSE),

(46, 'Océano Pacífico', TRUE),
(46, 'Océano Atlántico', FALSE),
(46, 'Océano Índico', FALSE),
(46, 'Océano Ártico', FALSE),

(47, 'Monte Everest', TRUE),
(47, 'K2', FALSE),
(47, 'Kangchenjunga', FALSE),
(47, 'Lhotse', FALSE),

(48, 'China', TRUE),
(48, 'India', FALSE),
(48, 'Estados Unidos', FALSE),
(48, 'Indonesia', FALSE),

(49, 'Mar Caspio', TRUE),
(49, 'Lago Superior', FALSE),
(49, 'Lago Victoria', FALSE),
(49, 'Lago Hurón', FALSE),

(50, 'Jordania', TRUE),
(50, 'Egipto', FALSE),
(50, 'Turquía', FALSE),
(50, 'Irak', FALSE);


-- Preguntas de música
INSERT INTO Pregunta_multiple_choise (Enunciado, Categoria, ID_Tematica) VALUES
('¿Quién es conocido como el Rey del Rock and Roll?', 'música', 6),
('¿Cuál es el álbum más vendido de todos los tiempos?', 'música', 6),
('¿Quién compuso la Novena Sinfonía?', 'música', 6),
('¿Cuál es el nombre real de Freddie Mercury?', 'música', 6),
('¿En qué año se lanzó el álbum "Thriller" de Michael Jackson?', 'música', 6),
('¿Qué banda británica lanzó el álbum "The Dark Side of the Moon"?', 'música', 6),
('¿Quién es conocido como el Rey del Pop?', 'música', 6),
('¿Cuál es el instrumento principal de Louis Armstrong?', 'música', 6),
('¿Qué cantante es conocido como "La Voz"?', 'música', 6),
('¿Quién escribió la ópera "La Traviata"?', 'música', 6);

-- Respuestas para las preguntas de música
INSERT INTO Respuesta (ID_Pregunta, Texto, Correcta) VALUES
(51, 'Elvis Presley', TRUE),
(51, 'Chuck Berry', FALSE),
(51, 'Little Richard', FALSE),
(51, 'Buddy Holly', FALSE),

(52, 'Thriller', TRUE),
(52, 'Back in Black', FALSE),
(52, 'The Dark Side of the Moon', FALSE),
(52, 'The Bodyguard', FALSE),

(53, 'Ludwig van Beethoven', TRUE),
(53, 'Wolfgang Amadeus Mozart', FALSE),
(53, 'Johann Sebastian Bach', FALSE),
(53, 'Franz Schubert', FALSE),

(54, 'Farrokh Bulsara', TRUE),
(54, 'Reginald Dwight', FALSE),
(54, 'David Jones', FALSE),
(54, 'Robert Zimmerman', FALSE),

(55, '1982', TRUE),
(55, '1980', FALSE),
(55, '1984', FALSE),
(55, '1986', FALSE),

(56, 'Pink Floyd', TRUE),
(56, 'The Beatles', FALSE),
(56, 'Led Zeppelin', FALSE),
(56, 'The Rolling Stones', FALSE),

(57, 'Michael Jackson', TRUE),
(57, 'Prince', FALSE),
(57, 'Madonna', FALSE),
(57, 'Elton John', FALSE),

(58, 'Trompeta', TRUE),
(58, 'Saxofón', FALSE),
(58, 'Piano', FALSE),
(58, 'Guitarra', FALSE),

(59, 'Frank Sinatra', TRUE),
(59, 'Dean Martin', FALSE),
(59, 'Bing Crosby', FALSE),
(59, 'Tony Bennett', FALSE),

(60, 'Giuseppe Verdi', TRUE),
(60, 'Giacomo Puccini', FALSE),
(60, 'Richard Wagner', FALSE),
(60, 'Wolfgang Amadeus Mozart', FALSE);


-- Preguntas de biología
INSERT INTO Pregunta_multiple_choise (Enunciado, Categoria, ID_Tematica) VALUES
('¿Cuál es la molécula que transporta el código genético?', 'biología', 7),
('¿Qué órgano del cuerpo humano produce insulina?', 'biología', 7),
('¿Cuál es el proceso por el cual las plantas producen su alimento?', 'biología', 7),
('¿Qué tipo de célula no tiene núcleo?', 'biología', 7),
('¿Cuál es el grupo sanguíneo considerado donante universal?', 'biología', 7),
('¿Qué estructura celular es responsable de la producción de energía?', 'biología', 7),
('¿Cuál es el nombre del pigmento que da color a la piel?', 'biología', 7),
('¿Qué tipo de organismo es una ameba?', 'biología', 7),
('¿Cuál es el hueso más largo del cuerpo humano?', 'biología', 7),
('¿Qué tipo de ácido se encuentra en el estómago?', 'biología', 7);

-- Respuestas para las preguntas de biología
INSERT INTO Respuesta (ID_Pregunta, Texto, Correcta) VALUES
(61, 'ADN', TRUE),
(61, 'ARN', FALSE),
(61, 'Proteína', FALSE),
(61, 'Lípido', FALSE),

(62, 'Páncreas', TRUE),
(62, 'Hígado', FALSE),
(62, 'Riñón', FALSE),
(62, 'Estómago', FALSE),

(63, 'Fotosíntesis', TRUE),
(63, 'Respiración', FALSE),
(63, 'Fermentación', FALSE),
(63, 'Digestión', FALSE),

(64, 'Procariota', TRUE),
(64, 'Eucariota', FALSE),
(64, 'Neurona', FALSE),
(64, 'Glóbulo rojo', FALSE),

(65, 'O-', TRUE),
(65, 'A+', FALSE),
(65, 'B+', FALSE),
(65, 'AB+', FALSE),

(66, 'Mitocondria', TRUE),
(66, 'Ribosoma', FALSE),
(66, 'Núcleo', FALSE),
(66, 'Cloroplasto', FALSE),

(67, 'Melanina', TRUE),
(67, 'Hemoglobina', FALSE),
(67, 'Caroteno', FALSE),
(67, 'Clorofila', FALSE),

(68, 'Protozoo', TRUE),
(68, 'Bacteria', FALSE),
(68, 'Virus', FALSE),
(68, 'Hongo', FALSE),

(69, 'Fémur', TRUE),
(69, 'Húmero', FALSE),
(69, 'Tibia', FALSE),
(69, 'Peroné', FALSE),

(70, 'Ácido clorhídrico', TRUE),
(70, 'Ácido sulfúrico', FALSE),
(70, 'Ácido acético', FALSE),
(70, 'Ácido láctico', FALSE);


-- Preguntas de entretenimiento
INSERT INTO Pregunta_multiple_choise (Enunciado, Categoria, ID_Tematica) VALUES
('¿Quién es el creador de la serie animada "Los Simpson"?', 'entretenimiento', 8),
('¿Cuál es la película con mayor recaudación de todos los tiempos?', 'entretenimiento', 8),
('¿Quién interpretó a Jack Dawson en "Titanic"?', 'entretenimiento', 8),
('¿Cuál es el nombre del parque temático de Disney en Florida?', 'entretenimiento', 8),
('¿En qué año se estrenó la primera película de "Star Wars"?', 'entretenimiento', 8),
('¿Cuál es el nombre del villano en "Los Vengadores"?', 'entretenimiento', 8),
('¿Qué serie de televisión presenta a un grupo de amigos en Nueva York?', 'entretenimiento', 8),
('¿Quién es el autor de la saga de libros "Harry Potter"?', 'entretenimiento', 8),
('¿Cuál es el nombre del protagonista en la serie "Breaking Bad"?', 'entretenimiento', 8),
('¿Qué película ganó el Oscar a la Mejor Película en 2020?', 'entretenimiento', 8);

-- Respuestas para las preguntas de entretenimiento
INSERT INTO Respuesta (ID_Pregunta, Texto, Correcta) VALUES
(71, 'Matt Groening', TRUE),
(71, 'Seth MacFarlane', FALSE),
(71, 'Trey Parker', FALSE),
(71, 'Mike Judge', FALSE),

(72, 'Avatar', TRUE),
(72, 'Avengers: Endgame', FALSE),
(72, 'Titanic', FALSE),
(72, 'Star Wars: The Force Awakens', FALSE),

(73, 'Leonardo DiCaprio', TRUE),
(73, 'Brad Pitt', FALSE),
(73, 'Johnny Depp', FALSE),
(73, 'Tom Cruise', FALSE),

(74, 'Walt Disney World', TRUE),
(74, 'Disneyland', FALSE),
(74, 'Epcot', FALSE),
(74, 'Magic Kingdom', FALSE),

(75, '1977', TRUE),
(75, '1980', FALSE),
(75, '1983', FALSE),
(75, '1986', FALSE),

(76, 'Thanos', TRUE),
(76, 'Loki', FALSE),
(76, 'Ultron', FALSE),
(76, 'Red Skull', FALSE),

(77, 'Friends', TRUE),
(77, 'How I Met Your Mother', FALSE),
(77, 'The Big Bang Theory', FALSE),
(77, 'Seinfeld', FALSE),

(78, 'J.K. Rowling', TRUE),
(78, 'Stephen King', FALSE),
(78, 'George R.R. Martin', FALSE),
(78, 'J.R.R. Tolkien', FALSE),

(79, 'Walter White', TRUE),
(79, 'Jesse Pinkman', FALSE),
(79, 'Saul Goodman', FALSE),
(79, 'Hank Schrader', FALSE),

(80, 'Parasite', TRUE),
(80, '1917', FALSE),
(80, 'Joker', FALSE),
(80, 'Once Upon a Time in Hollywood', FALSE);


--preguntas por arpoximacion

-- Preguntas de aproximación para deporte
INSERT INTO Pregunta_aproximacion (Enunciado, Categoria, Valor_Aproximado, ID_Tematica) VALUES
('¿En qué año se celebró la primera Copa del Mundo de la FIFA?', 'deporte', 1930, 1),
('¿Cuántos goles anotó Pelé en su carrera profesional?', 'deporte', 1281, 1),
('¿En qué año se celebraron los primeros Juegos Olímpicos modernos?', 'deporte', 1896, 1),
('¿Cuántas medallas de oro ganó Michael Phelps en los Juegos Olímpicos de Beijing 2008?', 'deporte', 8, 1),
('¿Cuántos Grand Slams ha ganado Roger Federer?', 'deporte', 20, 1),
('¿En qué año se fundó la NBA?', 'deporte', 1946, 1),
('¿Cuántos títulos de Fórmula 1 ha ganado Michael Schumacher?', 'deporte', 7, 1),
('¿En qué año se celebró el primer Super Bowl?', 'deporte', 1967, 1),
('¿Cuántos puntos anotó Kareem Abdul-Jabbar en su carrera en la NBA?', 'deporte', 38387, 1),
('¿Cuántos partidos ganó Rafael Nadal en Roland Garros hasta 2021?', 'deporte', 105, 1);


-- Preguntas de aproximación para arte
INSERT INTO Pregunta_aproximacion (Enunciado, Categoria, Valor_Aproximado, ID_Tematica) VALUES
('¿En qué año nació Leonardo da Vinci?', 'arte', 1452, 2),
('¿Cuántas pinturas completó Vincent van Gogh en su vida?', 'arte', 2100, 2),
('¿En qué año se inauguró el Museo del Louvre?', 'arte', 1793, 2),
('¿Cuántos años tenía Pablo Picasso cuando murió?', 'arte', 91, 2),
('¿En qué año se pintó la Mona Lisa?', 'arte', 1503, 2),
('¿Cuántas esculturas creó Auguste Rodin?', 'arte', 660, 2),
('¿En qué año se completó la Capilla Sixtina?', 'arte', 1512, 2),
('¿Cuántos cuadros pintó Claude Monet en su serie de Nenúfares?', 'arte', 250, 2),
('¿En qué año se fundó el Museo de Arte Moderno (MoMA) en Nueva York?', 'arte', 1929, 2),
('¿Cuántas obras de arte se exhiben en el Museo del Prado?', 'arte', 7600, 2);


-- Preguntas de aproximación para historia
INSERT INTO Pregunta_aproximacion (Enunciado, Categoria, Valor_Aproximado, ID_Tematica) VALUES
('¿En qué año comenzó la Primera Guerra Mundial?', 'historia', 1914, 3),
('¿Cuántos años duró el Imperio Romano?', 'historia', 507, 3),
('¿En qué año se firmó la Declaración de Independencia de los Estados Unidos?', 'historia', 1776, 3),
('¿Cuántos presidentes ha tenido Estados Unidos hasta 2021?', 'historia', 46, 3),
('¿En qué año cayó el Muro de Berlín?', 'historia', 1989, 3),
('¿Cuántos años duró la Guerra de los Cien Años?', 'historia', 116, 3),
('¿En qué año se descubrió América?', 'historia', 1492, 3),
('¿Cuántos años duró la Revolución Francesa?', 'historia', 10, 3),
('¿En qué año se fundó la ONU?', 'historia', 1945, 3),
('¿Cuántos faraones gobernaron el Antiguo Egipto?', 'historia', 170, 3);

-- Preguntas de aproximación para ciencia
INSERT INTO Pregunta_aproximacion (Enunciado, Categoria, Valor_Aproximado, ID_Tematica) VALUES
('¿En qué año se descubrió la penicilina?', 'ciencia', 1928, 4),
('¿Cuántos elementos hay en la tabla periódica?', 'ciencia', 118, 4),
('¿En qué año se publicó la teoría de la relatividad de Einstein?', 'ciencia', 1905, 4),
('¿Cuántos planetas hay en el sistema solar?', 'ciencia', 8, 4),
('¿En qué año se descubrió el ADN?', 'ciencia', 1953, 4),
('¿Cuántos años luz hay hasta la estrella más cercana?', 'ciencia', 4.24, 4),
('¿En qué año se lanzó el primer satélite artificial, Sputnik 1?', 'ciencia', 1957, 4),
('¿Cuántos cromosomas tiene un ser humano?', 'ciencia', 46, 4),
('¿En qué año se descubrió el electrón?', 'ciencia', 1897, 4),
('¿Cuántos huesos tiene el cuerpo humano?', 'ciencia', 206, 4);


-- Preguntas de aproximación para geografía
INSERT INTO Pregunta_aproximacion (Enunciado, Categoria, Valor_Aproximado, ID_Tematica) VALUES
('¿Cuántos países hay en el mundo?', 'geografía', 195, 5),
('¿En qué año se fundó la ciudad de Roma?', 'geografía', 753, 5),
('¿Cuántos estados tiene Estados Unidos?', 'geografía', 50, 5),
('¿En qué año se construyó la Gran Muralla China?', 'geografía', -221, 5),
('¿Cuántos continentes hay en el mundo?', 'geografía', 7, 5),
('¿En qué año se descubrió la Antártida?', 'geografía', 1820, 5),
('¿Cuántos países hay en África?', 'geografía', 54, 5),
('¿En qué año se fundó la ciudad de Nueva York?', 'geografía', 1624, 5),
('¿Cuántos países hay en Europa?', 'geografía', 44, 5),
('¿En qué año se construyó el Canal de Panamá?', 'geografía', 1914, 5);


-- Preguntas de aproximación para música
INSERT INTO Pregunta_aproximacion (Enunciado, Categoria, Valor_Aproximado, ID_Tematica) VALUES
('¿En qué año nació Ludwig van Beethoven?', 'música', 1770, 6),
('¿Cuántas sinfonías compuso Wolfgang Amadeus Mozart?', 'música', 41, 6),
('¿En qué año se lanzó el álbum "Thriller" de Michael Jackson?', 'música', 1982, 6),
('¿Cuántos años tenía Freddie Mercury cuando murió?', 'música', 45, 6),
('¿En qué año se fundó la banda The Beatles?', 'música', 1960, 6),
('¿Cuántos álbumes de estudio lanzó Elvis Presley?', 'música', 24, 6),
('¿En qué año se celebró el primer festival de Woodstock?', 'música', 1969, 6),
('¿Cuántos premios Grammy ha ganado Beyoncé hasta 2021?', 'música', 28, 6),
('¿En qué año se lanzó el álbum "The Dark Side of the Moon" de Pink Floyd?', 'música', 1973, 6),
('¿Cuántos años tenía Johann Sebastian Bach cuando murió?', 'música', 65, 6);


-- Preguntas de aproximación para biología
INSERT INTO Pregunta_aproximacion (Enunciado, Categoria, Valor_Aproximado, ID_Tematica) VALUES
('¿En qué año se descubrió la estructura del ADN?', 'biología', 1953, 7),
('¿Cuántos huesos tiene el cuerpo humano adulto?', 'biología', 206, 7),
('¿En qué año se publicó "El origen de las especies" de Charles Darwin?', 'biología', 1859, 7),
('¿Cuántos cromosomas tiene un ser humano?', 'biología', 46, 7),
('¿En qué año se descubrió la penicilina?', 'biología', 1928, 7),
('¿Cuántos litros de sangre tiene el cuerpo humano?', 'biología', 5, 7),
('¿En qué año se descubrió la célula?', 'biología', 1665, 7),
('¿Cuántos aminoácidos esenciales existen?', 'biología', 9, 7),
('¿En qué año se completó el Proyecto Genoma Humano?', 'biología', 2003, 7),
('¿Cuántos dientes tiene un ser humano adulto?', 'biología', 32, 7);


-- Preguntas de aproximación para entretenimiento
INSERT INTO Pregunta_aproximacion (Enunciado, Categoria, Valor_Aproximado, ID_Tematica) VALUES
('¿En qué año se estrenó la primera película de "Star Wars"?', 'entretenimiento', 1977, 8),
('¿Cuántos premios Oscar ha ganado Meryl Streep hasta 2021?', 'entretenimiento', 3, 8),
('¿En qué año se lanzó la primera película de "Harry Potter"?', 'entretenimiento', 2001, 8),
('¿Cuántos episodios tiene la serie "Friends"?', 'entretenimiento', 236, 8),
('¿En qué año se estrenó la primera película de "El Señor de los Anillos"?', 'entretenimiento', 2001, 8),
('¿Cuántos premios Grammy ha ganado Michael Jackson?', 'entretenimiento', 13, 8),
('¿En qué año se estrenó la primera película de "Jurassic Park"?', 'entretenimiento', 1993, 8),
('¿Cuántos episodios tiene la serie "Breaking Bad"?', 'entretenimiento', 62, 8),
('¿En qué año se estrenó la primera película de "Toy Story"?', 'entretenimiento', 1995, 8),
('¿Cuántos premios Emmy ha ganado la serie "Game of Thrones"?', 'entretenimiento', 59, 8);