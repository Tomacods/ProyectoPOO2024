# Documentación de la carpeta `controlador/`

Esta documentación presenta un resumen y explicación de los comentarios de documentación encontrados en los controladores dentro de la carpeta `8Escalones_Juego/Proyecto/src/controlador` del repositorio [ProyectoPOO2024](https://github.com/Tomacods/ProyectoPOO2024/tree/597e0af28e82c88d0e8b85e6a80c57ad5826ab92/8Escalones_Juego/Proyecto/src/controlador). **Nota:** Este resumen solo incluye los primeros 10 archivos de la carpeta (la lista puede estar incompleta, revisa todos los archivos en el [repositorio](https://github.com/Tomacods/ProyectoPOO2024/tree/597e0af28e82c88d0e8b85e6a80c57ad5826ab92/8Escalones_Juego/Proyecto/src/controlador)).

---

## 1. `ControladorABMJugadores.java`

**Descripción general:**
Controlador para la gestión de la vista de ABMJugadores, permitiendo agregar, editar, eliminar y seleccionar jugadores.

**Funcionalidades principales:**
- Inicializa la vista y carga la lista de jugadores.
- Permite agregar nuevos jugadores con nombre válido.
- Edita el nombre de un jugador seleccionado.
- Elimina jugadores desde la base de datos y la vista.
- Actualiza la selección de jugador y muestra información relevante.
- Permite volver al menú principal.

**Dependencias:**  
- Vista: `ABMJugadores`
- Modelo: `Jugador`
- Controlador: `MenuPrincipalController`

**Uso:**
```java
ControladorABMJugadores controlador = new ControladorABMJugadores();
```
*Asume que la vista y el modelo están correctamente conectados.*

---

## 2. `ControladorABMPreguntas.java`

**Descripción general:**
Gestiona la lógica de la vista ABMPreguntas para administrar preguntas (alta, baja, modificación) de tipo Multiple Choice o Aproximación asociadas a temáticas.

**Funcionalidades principales:**
- Carga y actualiza temáticas y preguntas.
- Gestión de eventos de la interfaz para insertar, modificar y eliminar preguntas.
- Interacción con modelos para obtener, actualizar y eliminar preguntas y temáticas.
- Implementa el patrón estrategia para manejar diferentes tipos de preguntas.

**Dependencias:**  
- Vista: `ABMPreguntas`
- Modelos: `Tematica`, `MultipleChoicePregunta`, `PreguntaAproximacion`
- Estrategias: `EstrategiaPregunta`, `EstrategiaPreguntaMC`, `EstrategiaPreguntaAprox`
- Controladores auxiliares: `ControladorABMRespuestaMC`, `ControladorABMRespuestaAprox`

**Manejo de errores:**  
- Captura errores de SQL y validaciones de campos obligatorios.

*Asume que la vista y los modelos están correctamente implementados y disponibles.*

---

## 3. `ControladorABMRespuestaAprox.java`

**Descripción general:**
Controlador para la vista de ABMRespuestaAprox, encargado de la creación y edición de preguntas de aproximación.

**Permite:**
- Inicializar la vista para creación o edición.
- Guardar cambios realizados en la pregunta.
- Insertar o actualizar en la base de datos.
- Gestionar la navegación de la interfaz.

**Atributos:**
- `vista`: instancia de la vista ABMRespuestaAprox.
- `preguntaActual`: pregunta de aproximación actual.
- `esNueva`: indica si es una nueva pregunta o se está editando.

**Métodos principales:**
- `iniciarVista()`: inicializa la vista y campos.
- `volver()`: guarda cambios e inserta/actualiza la pregunta.
- `guardarCambios()`: actualiza los atributos de la pregunta.

**Uso típico:**
```java
ControladorABMRespuestaAprox controlador = new ControladorABMRespuestaAprox(pregunta, true);
```

---

## 4. `ControladorABMRespuestaMC.java`

**Descripción general:**
Gestiona la vista y lógica para el alta, baja y modificación de respuestas de preguntas de tipo Multiple Choice.

**Funcionalidades principales:**
- Inicializa la vista y la pregunta actual.
- Permite modificar enunciado y respuestas.
- Gestiona la selección de la respuesta correcta.
- Guarda cambios (inserta o actualiza).
- Permite cerrar la ventana sin guardar.

**Dependencias:**  
- Vista: `ABMRespuestaMC`
- Modelos: `MultipleChoicePregunta`, `Respuesta`

**Uso:**
```java
ControladorABMRespuestaMC controlador = new ControladorABMRespuestaMC(pregunta, esNueva);
```

---

## 5. `ControladorABMTematica.java`

**Descripción general:**
Gestiona la lógica de la vista ABMTematicas, permitiendo la administración de temáticas (agregar, eliminar, modificar y seleccionar).

**Funcionalidades principales:**
- Inicializa y muestra la vista.
- Agrega listeners para manejar eventos.
- Permite insertar, eliminar y modificar temáticas.
- Actualiza el ComboBox de temáticas.
- Gestiona la navegación hacia la vista principal de administración.

**Dependencias:**  
- Vista: `ABMTematicas`
- Modelo: `Tematica`

**Uso:**
```java
ControladorABMTematica controlador = new ControladorABMTematica();
```
*Nota: Requiere que Tematica implemente métodos CRUD estáticos.*

---

## 6. `ControladorAdminContraseña.java`

**Descripción general:**
Gestiona la lógica de la vista de autenticación de administrador mediante contraseña.

**Funcionalidades principales:**
- Muestra la interfaz de ingreso de contraseña.
- Permite regresar a opciones generales.
- Valida la contraseña al presionar "Ingresar".
- Si es correcta, abre el modo administrador; si es incorrecta, muestra un error.

**Nota:**  
- Actualmente la contraseña es "admin" (hardcodeada). Se recomienda almacenarla en base de datos y permitir cambios futuros desde la administración.

---

## 7. `ControladorAyuda.java`

**Descripción general:**
Gestiona la ventana de ayuda (Ayuda) de la aplicación.

**Responsabilidades:**
- Muestra la ventana de ayuda al usuario.
- Gestiona el botón "Back" para cerrar la ayuda y volver al menú principal.

---

## 8. `ControladorCreditos.java`

**Descripción general:**
Gestiona la ventana de créditos del juego.

**Al instanciarse:**
- Crea y muestra la ventana de créditos.
- Gestiona el botón de salida (`jButtonExit`), cerrando la ventana y abriendo las opciones generales.

**Dependencias:**  
- Vista: `Creditos`
- Controlador: `ControladorOpcionesGenerales`

---

## 9. `ControladorGameplay.java`

**Descripción general:**
Controlador principal de la lógica del juego de preguntas y respuestas por rondas y temáticas.

**Funcionalidades principales:**
- Inicializa la vista y datos del juego.
- Gestiona el ciclo de rondas, mostrando preguntas y evaluando respuestas.
- Actualiza y muestra puntajes.
- Elimina jugadores según desempeño.
- Controla la transición entre vistas (escalón, aproximación, final).
- Selección aleatoria de temáticas y preguntas.
- Implementa listeners para respuestas.
- Decide el flujo del juego (quién sigue, desempates, etc).

**Dependencias:**  
- Vista: `Gameplay`
- Modelos: `Jugador`, `Tematica`, `MultipleChoicePregunta`, `Respuesta`
- Controladores auxiliares: `ControladorGameplayFinal`, `ControladorSiguienteEscalon`, `ControladorGameplayAproximacion`

---

## 10. `ControladorGameplayAproximacion.java`

**Descripción general:**
Gestiona la ronda de desempate por aproximación en el juego. Coordina la interacción entre la vista y el modelo (jugadores, temáticas y preguntas de aproximación).

**Funcionalidades principales:**
- Inicializa la vista y datos para el desempate.
- Gestiona la entrada de respuestas numéricas de jugadores empatados.
- Selecciona preguntas y evalúa respuestas.
- Elimina al jugador con peor aproximación.
- Muestra mensajes informativos sobre el eliminado y la respuesta correcta.
- Permite avanzar al siguiente escalón.
- Valida que solo se ingresen números.

**Campos principales:**  
- Vista: `GameplayAproximacion`
- Listas de jugadores empatados y que siguen jugando.
- Temáticas restantes y tema de la ronda.
- Jugador eliminado.

**Uso:**  
Se instancia cuando hay un empate a resolver por aproximación.

---

## Notas

- **Esta documentación se ha generado a partir de los comentarios de documentación incluidos en los archivos fuente. Si algún archivo no contiene comentarios, puede que no aparezca aquí.**
- **Para consultar otros archivos del directorio, visita [la carpeta en GitHub](https://github.com/Tomacods/ProyectoPOO2024/tree/597e0af28e82c88d0e8b85e6a80c57ad5826ab92/8Escalones_Juego/Proyecto/src/controlador).**