<<<<<<< HEAD
# Centro Cultural Estación Sur — proyecto base JavaFX

**DSY1102 · Programación Orientada a Objetos · EA2**  
**Versión:** 1.0.0 · **JDK:** 21 · **Build:** Maven · **UI:** JavaFX 21 · **Persistencia a desarrollar:** Jackson

## Contexto de práctica

El Centro Cultural Estación Sur organiza talleres **presenciales** y **virtuales**. El modelo existente representa ambos tipos y calcula un arancel por persona según la modalidad, duración y características propias de cada taller. La institución necesita una **aplicación de escritorio de una sola ventana** para registrar, listar y eliminar talleres, y conservar la información en archivos JSON al cerrar la aplicación.

Este proyecto corresponde a un **caso de práctica original** y no reproduce las formas de evaluación D y E. La parte del modelo ya está **implementada y probada** para que puedas concentrarte en la interfaz y persistencia.

## Lo que viene resuelto

- Proyecto Maven con JavaFX 21, Java 21 y ejecución mediante `javafx:run`.
- `App`: clase de arranque que abre una ventana JavaFX con un mensaje inicial. No es la pantalla solicitada: debes reemplazarla con tu vista FXML.
- Modelo `Taller`, `TallerPresencial` y `TallerVirtual`, con constructores, getters/setters, validaciones y cálculo del arancel.
- Pruebas JUnit del modelo; puedes ejecutarlas para conocer sus garantías sin modificar su lógica.
- Carpeta de recursos lista para tus FXML y CSS.

## Reglas ya implementadas en el modelo

**Datos comunes** para todos los talleres:

- `codigo`: texto obligatorio; se eliminan espacios iniciales/finales.
- `nombre`: texto obligatorio; se eliminan espacios iniciales/finales.
- `duracionHoras`: entero entre 1 y 40.
- `cupos`: entero entre 1 y 40.

**Taller presencial:**

- `sala`: texto obligatorio.
- `materialesIncluidos`: booleano.
- Arancel por persona: **$10.000 por cada hora**, más **$3.500** si incluye materiales.

**Taller virtual:**

- `plataforma`: texto obligatorio.
- `grabacionDisponible`: booleano.
- Arancel por persona: **$7.000 por cada hora**, más **$2.000** si se entrega grabación.

Los métodos públicos `calcularArancel()` y `tipo()` entregan el valor de negocio y el nombre de modalidad. No dupliques sus reglas en el Controller.

## Cómo empezar en IntelliJ

1. Descomprime el ZIP y abre esta carpeta como proyecto Maven.
2. Confirma que el IDE utiliza **JDK 21** y recarga el proyecto Maven.
3. Ejecuta `App`, o abre la terminal del proyecto y utiliza `mvn javafx:run`.
4. Debe aparecer una ventana titulada **Centro Cultural Estación Sur — base** con el texto **Proyecto base listo**.
5. Ejecuta `mvn test` para comprobar el modelo. Si Maven requiere descargar dependencias, configura el acceso al repositorio de dependencias **antes** de una evaluación sin internet.

## Tu trabajo durante las 10 cápsulas

- Diseñar y cargar la **única ventana** FXML con controles y Controller.
- Mostrar/ocultar o habilitar/deshabilitar los campos específicos al elegir modalidad.
- Construir la `TableView` y su `ObservableList`.
- Implementar registro, validación del formulario, mensajes dentro de la ventana y eliminación por selección.
- Organizar MVC y crear el contrato e implementación DAO/Repository.
- **Agregar la dependencia `jackson-databind` a Maven** y trabajar con `ObjectMapper` para persistencia JSON, en **dos archivos separados** (`talleres_presenciales.json` y `talleres_virtuales.json`). Los archivos no se entregan: tu aplicación los debe crear.
- Cargar desde disco al iniciar, guardar tras registro/eliminación y verificar que los cambios sobreviven a un reinicio completo.

**Importante:** la capa DAO, el Controller y el FXML **no vienen resueltos**, deliberadamente. Son el trabajo del estudiante. No necesitas crear otro modelo ni inventar cálculos.

## Clases disponibles

| Clase | Constructor principal | Métodos a reconocer |
| --- | --- | --- |
| `Taller` | Abstracta, recibe datos comunes | `getCodigo()`, `getNombre()`, `getDuracionHoras()`, `getCupos()`, `calcularArancel()`, `tipo()` |
| `TallerPresencial` | `(codigo, nombre, duracionHoras, cupos, sala, materialesIncluidos)` | `getSala()`, `isMaterialesIncluidos()`, `calcularArancel()` |
| `TallerVirtual` | `(codigo, nombre, duracionHoras, cupos, plataforma, grabacionDisponible)` | `getPlataforma()`, `isGrabacionDisponible()`, `calcularArancel()` |

El modelo incluye **constructores sin argumentos** para que Jackson pueda reconstruir objetos de cada subtipo. Al persistir en archivos separados, puedes deserializar cada colección con su **clase concreta** y evitar tratar todos los registros como si fueran un solo tipo abstracto. La forma de hacerlo es parte del ejercicio.

## Estructura

```text
estacion-sur-base/
├── pom.xml
├── README.md
├── docs/DIAGRAMA-MODELO.md
├── src/main/java/cl/adumun/academiclabs/dsy1102/estacionsur/
│   ├── App.java
│   └── model/
│       ├── Taller.java
│       ├── TallerPresencial.java
│       └── TallerVirtual.java
├── src/main/resources/
│   └── (espacio para FXML y CSS)
└── src/test/java/cl/adumun/academiclabs/dsy1102/estacionsur/model/
    └── TallerTest.java
```

## Checklist de partida

- [ ] `mvn test` finaliza correctamente.
- [ ] `mvn javafx:run` abre la ventana inicial.
- [ ] He reconocido constructores y validaciones existentes.
- [ ] Sé dónde guardaré FXML/CSS y qué responsabilidad tendrá mi Controller.
- [ ] No he modificado el modelo entregado.

**Material de práctica.** Respeta las condiciones específicas de cualquier evaluación individual. No se entrega código de solución de las cápsulas ni materiales reservados.
=======
# VicenteGodoy_DSY1102_012V
Repositorio para ramo de Desarrollo orientado a objetos

# DevLog · Semana 1

## Objetivo
¿Qué quería avanzar esta semana?
Comprender el concepto de clases y la estucturas/formato que utiliza java 


## Avance

PENDIENTE DE ESTUDIO

## Bloqueo
Inicialmente no entiendo nada
PENDIENTE  

## Aprendizaje

PENDIENTE

## Siguiente

PENDIENTE
>>>>>>> a832700c364a827bcec7b2d2fee5737fcd13af77
