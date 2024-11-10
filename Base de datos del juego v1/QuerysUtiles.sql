SELECT --esta query devuelve las preguntas de la tematica historia con sus respectivas respuestas
    p.ID_Pregunta_mc AS ID_Pregunta, p.Enunciado,r.ID_Respuesta,r.Texto AS Respuesta,r.Correcta
FROM 
    Pregunta_multiple_choise p
JOIN 
    Respuesta r ON p.ID_Pregunta_mc = r.ID_Pregunta
WHERE 
    p.ID_Tematica = (SELECT ID_Tematica FROM Tematica WHERE Nombre_Tematica = 'historia')
ORDER BY 
    p.ID_Pregunta_mc, r.ID_Respuesta;



SELECT --solamente devuelve las respuestas correctas de las preguntas de la temática "historia"
    p.ID_Pregunta_mc AS ID_Pregunta,
    p.Enunciado,
    r.ID_Respuesta,
    r.Texto AS Respuesta_Correcta
FROM 
    Pregunta_multiple_choise p
JOIN 
    Respuesta r ON p.ID_Pregunta_mc = r.ID_Pregunta
WHERE 
    p.ID_Tematica = (
        SELECT ID_Tematica 
        FROM Tematica 
        WHERE Nombre_Tematica = 'historia'
    )
    AND r.Correcta = TRUE
ORDER BY 
    p.ID_Pregunta_mc, r.ID_Respuesta;

SELECT -- devuelve todas las preguntas de historia de aproximacion
    ID_Pregunta,
    Enunciado,
    Categoria,
    Valor_Aproximado
FROM 
    Pregunta_aproximacion
WHERE 
    ID_Tematica = (
        SELECT ID_Tematica 
        FROM Tematica 
        WHERE Nombre_Tematica = 'historia'
    )
ORDER BY 
    ID_Pregunta;


