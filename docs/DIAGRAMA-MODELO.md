# Diagrama del modelo entregado

```mermaid
classDiagram
  class Taller {
    <<abstract>>
    -String codigo
    -String nombre
    -int duracionHoras
    -int cupos
    +calcularArancel() int
    +tipo() String
  }
  class TallerPresencial {
    -String sala
    -boolean materialesIncluidos
    +calcularArancel() int
    +tipo() String
  }
  class TallerVirtual {
    -String plataforma
    -boolean grabacionDisponible
    +calcularArancel() int
    +tipo() String
  }
  Taller <|-- TallerPresencial
  Taller <|-- TallerVirtual
```

Ambos tipos representan talleres del mismo centro cultural, pero mantienen datos específicos y cálculos propios. Los valores ya se encuentran implementados en el modelo Java: **no reescribir las reglas ni los métodos de cálculo**.
