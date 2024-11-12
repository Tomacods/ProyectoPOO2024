-- Tabla Jugador
CREATE TABLE Jugador (
    ID_Jugador SERIAL PRIMARY KEY,
    Nombre VARCHAR(50), -- Nombre del jugador
    Puntaje INT, -- Puntaje del jugador en el juego (cuantas preguntas respondio correctamente)
    Estado VARCHAR(20) CHECK (Estado IN ('activo', 'eliminado')) -- Estado del jugador si esta jugando o quedo eliminado
);

-- Tabla Temática
CREATE TABLE Tematica ( -- Tabla que contiene las temáticas de las preguntas
    ID_Tematica SERIAL PRIMARY KEY,
    Nombre_Tematica VARCHAR(50)
);

-- Tabla Pregunta multiple choise
CREATE TABLE Pregunta_multiple_choise (
    ID_Pregunta_mc SERIAL PRIMARY KEY, --tiene q ser auto 
    Enunciado TEXT, -- Enunciado de la pregunta
    ID_Tematica INT,
    FOREIGN KEY (ID_Tematica) REFERENCES Tematica(ID_Tematica) -- ID de la temática a la que pertenece la pregunta
);

-- Tabla Pregunta aproximación
CREATE TABLE Pregunta_aproximacion (
    ID_Pregunta SERIAL PRIMARY KEY, --tiene q ser auto 
    Enunciado TEXT, -- Enunciado de la pregunta
    Valor_Aproximado INT, -- Valor aproximado de la pregunta (para las preguntas de aproximación)
    ID_Tematica INT,
    FOREIGN KEY (ID_Tematica) REFERENCES Tematica(ID_Tematica) -- ID de la temática a la que pertenece la pregunta
);

-- Tabla Respuesta
CREATE TABLE Respuesta (
    ID_Respuesta SERIAL PRIMARY KEY,  -- ID de la respuesta TIENE Q SER AUTOINC
    ID_Pregunta INT,
    Texto TEXT,
    Correcta BOOLEAN,
    FOREIGN KEY (ID_Pregunta) REFERENCES Pregunta_multiple_choise(ID_Pregunta_mc) -- ID de la pregunta a la que pertenece la respuesta
);

-- Tabla Escalón
CREATE TABLE Escalon ( -- Tabla que contiene los escalones de las preguntas
    ID_Escalon SERIAL PRIMARY KEY, --AUTO INC
    Numero_Escalon INT,
    ID_Tematica INT,
    Estado VARCHAR(20) CHECK (Estado IN ('pendiente', 'completado')), -- Estado del escalón si esta jugandose o ya se completo, se puede usar para ver si se sigue jugando o no
    FOREIGN KEY (ID_Tematica) REFERENCES Tematica(ID_Tematica) -- ID de la temática a la que pertenece el escalón
);

-- Tabla Juego
CREATE TABLE Juego ( -- Tabla que contiene los juegos que se jugaron, para despues mostrarlos en el historial
    ID_Juego SERIAL PRIMARY KEY,
    Fecha DATE,
    Estado VARCHAR(20) CHECK (Estado IN ('en curso', 'completado')), -- Estado del juego si esta jugandose o ya se completo
    ID_Jugador_Ganador INT,
    FOREIGN KEY (ID_Jugador_Ganador) REFERENCES Jugador(ID_Jugador) -- ID del jugador ganador del juego
);

-- Tabla Ronda
CREATE TABLE Ronda ( -- Tabla que contiene las rondas de los juegos
    ID_Ronda SERIAL PRIMARY KEY, --AUTO INC
    ID_Juego INT, -- ID del juego al que pertenece la ronda
    ID_Jugador INT,
    ID_Pregunta INT,
    ID_Escalon INT,
    Fecha DATE,
    Estado VARCHAR(20) CHECK (Estado IN ('en curso', 'finalizado')), -- Estado de la ronda si esta jugandose o ya se completo
    FOREIGN KEY (ID_Juego) REFERENCES Juego(ID_Juego),  -- ID del juego al que pertenece la ronda
    FOREIGN KEY (ID_Jugador) REFERENCES Jugador(ID_Jugador), -- ID del jugador que jugo la ronda
    FOREIGN KEY (ID_Pregunta) REFERENCES Pregunta_multiple_choise(ID_Pregunta_mc), -- ID de la pregunta que se jugo en la ronda
    FOREIGN KEY (ID_Escalon) REFERENCES Escalon(ID_Escalon) -- ID del escalón que se jugo en la ronda
);
