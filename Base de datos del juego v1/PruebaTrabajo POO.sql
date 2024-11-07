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
    Categoria VARCHAR(50), -- Categoría de la pregunta
    -- Respuesta_Correcta TEXT, -- Respuesta correcta de la pregunta | Una sola respuesta tendrá el valor True en Correcta BOOLEAN
    Valor_Aproximado DECIMAL(10, 2) -- Valor aproximado de la pregunta (para las preguntas de aproximación)
); --el valor aproximado no se si es necesario, pero lo puse por si se llega a necesitar

-- Tabla Respuesta
CREATE TABLE Respuesta (
    ID_Respuesta INT PRIMARY KEY,  -- ID de la respuesta
    ID_Pregunta INT,
    Texto TEXT,
    Correcta BOOLEAN,
    FOREIGN KEY (ID_Pregunta) REFERENCES Pregunta(ID_Pregunta) -- ID de la pregunta a la que pertenece la respuesta
);

-- Tabla Temática
CREATE TABLE Tematica ( -- Tabla que contiene las temáticas de las preguntas
    ID_Tematica INT  PRIMARY KEY AUTO_INCREMENT,
    Nombre_Tematica VARCHAR(50)
);

-- Tabla Escalón
CREATE TABLE Escalon ( -- Tabla que contiene los escalones de las preguntas
    ID_Escalon INT PRIMARY KEY,
    Numero_Escalon INT,
    ID_Tematica INT,
    Estado VARCHAR(20) CHECK (Estado IN ('pendiente', 'completado')), -- Estado del escalón si esta jugandose o ya se completo
    FOREIGN KEY (ID_Tematica) REFERENCES Tematica(ID_Tematica) -- ID de la temática a la que pertenece el escalón
);

-- Tabla Juego
CREATE TABLE Juego ( -- Tabla que contiene los juegos 
    ID_Juego INT PRIMARY KEY,
    Fecha DATE,
    Estado VARCHAR(20) CHECK (Estado IN ('en curso', 'completado')), -- Estado del juego si esta jugandose o ya se completo
    ID_Jugador_Ganador INT,
    FOREIGN KEY (ID_Jugador_Ganador) REFERENCES Jugador(ID_Jugador) -- ID del jugador ganador del juego
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
    FOREIGN KEY (ID_Escalon) REFERENCES Escalon(ID_Escalon) -- ID del escalón que se jugo en la ronda
);

