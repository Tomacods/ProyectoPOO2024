-- Tabla Jugador
CREATE TABLE Jugador (
    ID_Jugador INT PRIMARY KEY,
    Nombre VARCHAR(50), -- Nombre del jugador
    Apellido VARCHAR(50), -- datos que pueden servir mas adelante
    Correo VARCHAR(100), -- datos que pueden servir mas adelante
    Puntaje INT, -- Puntaje del jugador en el juego (cuantas preguntas respondio correctamente)
    Estado VARCHAR(20) CHECK (Estado IN ('activo', 'eliminado')) -- Estado del jugador si esta jugando o quedo eliminado
);

-- Tabla Pregunta
CREATE TABLE Pregunta (
    ID_Pregunta INT PRIMARY KEY,
    Enunciado TEXT, -- Enunciado de la pregunta
    Tipo_Pregunta VARCHAR(20) CHECK (Tipo_Pregunta IN ('multiple_choice', 'aproximación')), -- Tipo de pregunta
    Categoría VARCHAR(50), -- Categoría de la pregunta
    Dificultad VARCHAR(20) CHECK (Dificultad IN ('baja', 'media', 'alta')), -- Dificultad de la pregunta (esto no hace falta)
    Respuesta_Correcta TEXT, -- Respuesta correcta de la pregunta
    Valor_Aproximado DECIMAL(10, 2) -- Valor aproximado de la pregunta (para las preguntas de aproximación)
);

-- Tabla Respuesta
CREATE TABLE Respuesta (
    ID_Respuesta INT PRIMARY KEY,  -- ID de la respuesta
    ID_Pregunta INT,
    Texto TEXT,
    Correcta BOOLEAN,
    FOREIGN KEY (ID_Pregunta) REFERENCES Pregunta(ID_Pregunta) -- ID de la pregunta a la que pertenece la respuesta
);

-- Tabla Temática
CREATE TABLE Temática ( -- Tabla que contiene las temáticas de las preguntas
    ID_Temática INT PRIMARY KEY,
    Nombre_Temática VARCHAR(50)
);

-- Tabla Escalón
CREATE TABLE Escalón ( -- Tabla que contiene los escalones de las preguntas
    ID_Escalon INT PRIMARY KEY,
    Número_Escalon INT,
    ID_Temática INT,
    Estado VARCHAR(20) CHECK (Estado IN ('pendiente', 'completado')), -- Estado del escalón si esta jugandose o ya se completo
    FOREIGN KEY (ID_Temática) REFERENCES Temática(ID_Temática) -- ID de la temática a la que pertenece el escalón
);



-- Tabla Juego
CREATE TABLE Juego (
    ID_Juego INT PRIMARY KEY,
    Fecha DATE,
    Estado VARCHAR(20) CHECK (Estado IN ('en curso', 'completado')), -- Estado del juego si esta jugandose o ya se completo
    ID_Jugador_Ganador INT,
    FOREIGN KEY (ID_Jugador_Ganador) REFERENCES Jugador(ID_Jugador) -- ID del jugador ganador del juego
);

-- Tabla Empate
CREATE TABLE Empate ( -- Tabla que contiene los empates entre jugadores
    ID_Empate INT PRIMARY KEY,
    ID_Pregunta_Aproximacion INT,
    FOREIGN KEY (ID_Pregunta_Aproximacion) REFERENCES Pregunta(ID_Pregunta) -- ID de la pregunta de aproximación que genero el empate
);

-- Tabla Empate_Jugador
CREATE TABLE Empate_Jugador ( -- Tabla que contiene los jugadores que empataron
    ID_Empate INT,
    ID_Jugador INT,
    Es_Ganador BOOLEAN,
    PRIMARY KEY (ID_Empate, ID_Jugador), -- Clave primaria compuesta
    FOREIGN KEY (ID_Empate) REFERENCES Empate(ID_Empate), -- ID del empate
    FOREIGN KEY (ID_Jugador) REFERENCES Jugador(ID_Jugador) -- ID del jugador que empato
);


-- Tabla Ronda
CREATE TABLE Ronda ( -- Tabla que contiene las rondas de los juegos
    ID_Ronda INT PRIMARY KEY,
    ID_Juego INT, -- ID del juego al que pertenece la ronda
    ID_Jugador INT,
    ID_Pregunta INT,
    ID_Escalon INT,
    Resultado VARCHAR(20) CHECK (Resultado IN ('correcto', 'incorrecto', 'aproximado')), -- Resultado de la ronda
    Fecha DATE,
    Estado VARCHAR(20) CHECK (Estado IN ('en curso', 'finalizado')), -- Estado de la ronda si esta jugandose o ya se completo
    FOREIGN KEY (ID_Juego) REFERENCES Juego(ID_Juego),  -- ID del juego al que pertenece la ronda
    FOREIGN KEY (ID_Jugador) REFERENCES Jugador(ID_Jugador), -- ID del jugador que jugo la ronda
    FOREIGN KEY (ID_Pregunta) REFERENCES Pregunta(ID_Pregunta), -- ID de la pregunta que se jugo en la ronda
    FOREIGN KEY (ID_Escalon) REFERENCES Escalón(ID_Escalon) -- ID del escalón que se jugo en la ronda
);