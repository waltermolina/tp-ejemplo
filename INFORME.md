# Informe - Trabajo Práctico de Programación Orientada a Objetos

**Alumno:** Walter Molina  
**Fecha:** 6 de Mayo de 2026  
**Materia:** Algoritmos y Estructuras de Datos II  

---

## 1. Introducción

Este trabajo práctico tiene como objetivo aplicar los conceptos fundamentales de la Programación Orientada a Objetos (POO) en Java, específicamente:
- Creación de clases y objetos
- Encapsulamiento de datos
- Relaciones entre clases
- Validación de datos

El sistema implementado modela un entorno académico con las entidades: **Estudiante**, **Materia**, **Carrera** y **Universidad**.

---

## 2. Aplicación del Encapsulamiento

### 2.1 ¿Qué es el encapsulamiento?

El encapsulamiento es uno de los pilares fundamentales de la POO que consiste en:
- **Ocultar** los datos internos de una clase declarándolos como `private`
- **Controlar el acceso** a esos datos mediante métodos públicos (`getters` y `setters`)
- **Proteger la integridad** de los datos mediante validaciones

### 2.2 Implementación en nuestras clases

En todas las clases del proyecto (`Estudiante`, `Materia`, `Carrera` y `Universidad`), aplicamos encapsulamiento de la siguiente manera:

#### Ejemplo en la clase `Estudiante`:

```java
public class Estudiante {
    // Atributos PRIVADOS - no se pueden acceder directamente desde fuera
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private double promedio;
    
    // Métodos públicos para acceder a los atributos (GETTERS)
    public String getNombre() {
        return nombre;
    }
    
    // Métodos públicos para modificar los atributos (SETTERS)
    public void setNombre(String nombre) {
        // Incluye validación antes de asignar
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío");
            return;
        }
        this.nombre = nombre;
    }
}
```

### 2.3 Ventajas del encapsulamiento en nuestro sistema

1. **Protección de datos**: No se pueden asignar valores inválidos directamente a los atributos
2. **Mantenibilidad**: Si necesitamos cambiar la lógica de validación, solo modificamos los setters
3. **Flexibilidad**: Podemos agregar lógica adicional (logging, eventos, etc.) en los métodos de acceso
4. **Consistencia**: Los datos siempre están en un estado válido

---

## 3. Implementación de Relaciones entre Clases

Las relaciones entre clases permiten modelar entidades del mundo real de manera más precisa. En nuestro sistema implementamos varios tipos de relaciones:

### 3.1 Relación Estudiante - Materia (Agregación)

Un estudiante puede estar inscrito en **múltiples materias**. Esta es una relación de **uno a muchos**.

**Implementación:**

```java
public class Estudiante {
    private ArrayList<Materia> materias; // Colección de materias
    
    public void agregarMateria(Materia materia) {
        if (materia != null) {
            this.materias.add(materia);
        }
    }
    
    public double calcularPromedio() {
        double suma = 0;
        for (Materia materia : materias) {
            suma += materia.getCalificacion();
        }
        return suma / materias.size();
    }
}
```

**Características:**
- Se utiliza `ArrayList<Materia>` para almacenar múltiples materias
- El método `agregarMateria()` gestiona la relación
- El método `calcularPromedio()` utiliza la relación para calcular el promedio de todas las materias

### 3.2 Relación Carrera - Estudiante (Agregación)

Una carrera tiene **múltiples estudiantes** inscritos. Esta es una relación de **uno a muchos**.

**Implementación:**

```java
public class Carrera {
    private ArrayList<Estudiante> estudiantes;
    
    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            this.estudiantes.add(estudiante);
            estudiante.setCarrera(this.nombre); // Bidireccionalidad
        }
    }
    
    public void listarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
        }
    }
    
    public Estudiante buscarEstudiante(String nombre) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return estudiante;
            }
        }
        return null;
    }
}
```

**Características:**
- Relación **bidireccional**: cuando se agrega un estudiante a la carrera, se actualiza el atributo `carrera` del estudiante
- Métodos de gestión: agregar, listar y buscar estudiantes
- Búsqueda por nombre sin distinción entre mayúsculas y minúsculas

### 3.3 Relación Universidad - Estudiante y Carrera (Agregación)

Una universidad contiene **múltiples estudiantes** y **múltiples carreras**.

**Implementación:**

```java
public class Universidad {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Carrera> carreras;
    
    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }
    
    public void agregarCarrera(Carrera carrera) {
        this.carreras.add(carrera);
    }
    
    public void listarEstudiantes() { /* ... */ }
    public void listarCarreras() { /* ... */ }
}
```

### 3.4 Diagrama de relaciones

```
Universidad
    |
    |-- tiene múltiples --> Carrera
    |                          |
    |                          |-- tiene múltiples --> Estudiante
    |                                                      |
    |-- tiene múltiples -------------------------------→  |
                                                           |
                                                           |-- tiene múltiples --> Materia
```

---

## 4. Validaciones en los Métodos Setter

Las validaciones son fundamentales para mantener la **integridad de los datos**. Implementamos las siguientes validaciones:

### 4.1 Validación de Edad

**Regla:** La edad debe ser mayor a 16 años.

```java
public void setEdad(int edad) {
    if (edad <= 16) {
        System.out.println("Error: La edad debe ser mayor a 16 años");
        return;
    }
    this.edad = edad;
}
```

**Justificación:** Se asume que los estudiantes universitarios deben tener al menos 17 años.

### 4.2 Validación de Promedio

**Regla:** El promedio debe estar entre 0 y 10.

```java
public void setPromedio(double promedio) {
    if (promedio < 0 || promedio > 10) {
        System.out.println("Error: El promedio debe estar entre 0 y 10");
        return;
    }
    this.promedio = promedio;
}
```

**Justificación:** En el sistema educativo argentino, las calificaciones se miden en una escala de 0 a 10.

### 4.3 Validación de Textos Vacíos

**Regla:** Nombre, apellido y otros campos de texto no pueden estar vacíos.

```java
public void setNombre(String nombre) {
    if (nombre == null || nombre.trim().isEmpty()) {
        System.out.println("Error: El nombre no puede estar vacío");
        return;
    }
    this.nombre = nombre;
}

public void setApellido(String apellido) {
    if (apellido == null || apellido.trim().isEmpty()) {
        System.out.println("Error: El apellido no puede estar vacío");
        return;
    }
    this.apellido = apellido;
}
```

**Justificación:** Los datos identificatorios son obligatorios para identificar correctamente a los estudiantes.

### 4.4 Validación de Calificaciones en Materia

```java
public void setCalificacion(double calificacion) {
    if (calificacion < 0 || calificacion > 10) {
        System.out.println("Error: La calificación debe estar entre 0 y 10");
        return;
    }
    this.calificacion = calificacion;
}
```

### 4.5 Validación de Créditos

```java
public void setCreditos(int creditos) {
    if (creditos <= 0) {
        System.out.println("Error: Los créditos deben ser mayores a 0");
        return;
    }
    this.creditos = creditos;
}
```

### 4.6 Comportamiento ante errores

Cuando se intenta asignar un valor inválido:
1. Se muestra un **mensaje de error** descriptivo en la consola
2. El atributo **NO se modifica**, manteniendo su valor anterior (o el valor por defecto)
3. El método retorna sin lanzar excepciones, permitiendo que el programa continúe

---

## 5. Métodos Adicionales Implementados

Además de los getters y setters, implementamos métodos de lógica de negocio:

### En la clase `Estudiante`:

- **`agregarMateria(Materia materia)`**: Agrega una materia al listado del estudiante
- **`calcularPromedio()`**: Calcula automáticamente el promedio de todas las materias
- **`mostrarMaterias()`**: Muestra todas las materias con sus detalles

### En la clase `Carrera`:

- **`agregarEstudiante(Estudiante estudiante)`**: Agrega un estudiante a la carrera
- **`listarEstudiantes()`**: Muestra todos los estudiantes inscritos
- **`buscarEstudiante(String nombre)`**: Busca un estudiante por nombre o apellido
- **`obtenerPromedioGeneral()`**: Calcula el promedio de todos los estudiantes

### En la clase `Universidad`:

- **`agregarEstudiante(Estudiante estudiante)`**: Registra un estudiante en la universidad
- **`agregarCarrera(Carrera carrera)`**: Registra una carrera en la universidad
- **`listarEstudiantes()`**: Lista todos los estudiantes
- **`listarCarreras()`**: Lista todas las carreras

---

## 6. Demostración en el Método Main

El método `main` de la clase `App` demuestra todas las funcionalidades:

1. **Creación de objetos** con ambos constructores (sin parámetros y con parámetros)
2. **Almacenamiento en arreglo** y recorrido con iteración
3. **Validaciones en acción** mostrando mensajes de error
4. **Creación de una carrera** y adición de estudiantes
5. **Asignación de materias** a los estudiantes
6. **Cálculo automático de promedios**
7. **Búsqueda de estudiantes** por nombre
8. **Gestión de universidad** con múltiples carreras y estudiantes
9. **Resumen final** con todas las funcionalidades demostradas

---

## 7. Estructura del Proyecto

```
tp0/
├── App.java           # Clase principal con método main
├── Estudiante.java    # Clase Estudiante con encapsulamiento
├── Materia.java       # Clase Materia con encapsulamiento
├── Carrera.java       # Clase Carrera con gestión de estudiantes
├── Universidad.java   # Clase Universidad con gestión general
└── INFORME.md        # Este informe
```

---

## 8. Conclusiones

### 8.1 Aprendizajes obtenidos

- **Encapsulamiento**: Aprendimos a proteger los datos mediante modificadores de acceso y métodos controlados
- **Relaciones**: Comprendimos cómo modelar relaciones del mundo real usando agregación y composición
- **Validaciones**: Implementamos reglas de negocio para mantener la integridad de los datos
- **Buenas prácticas**: Aplicamos convenciones de Java (nombres de métodos, estructura de código)

### 8.2 Ventajas del enfoque orientado a objetos

1. **Modularidad**: Cada clase tiene una responsabilidad clara y específica
2. **Reutilización**: Las clases pueden ser utilizadas en diferentes contextos
3. **Mantenibilidad**: El código es fácil de entender y modificar
4. **Extensibilidad**: Es sencillo agregar nuevas funcionalidades

### 8.3 Posibles mejoras futuras

- Implementar **excepciones personalizadas** en lugar de solo imprimir mensajes
- Agregar **persistencia de datos** (guardar en archivos o base de datos)
- Implementar **interfaces** para definir contratos
- Agregar **herencia** (por ejemplo, diferentes tipos de estudiantes)
- Implementar **polimorfismo** para comportamientos especializados

---

## 9. Ejecución del Programa

Para compilar y ejecutar el proyecto:

```bash
# Compilar todas las clases
javac *.java

# Ejecutar la aplicación
java App
```

El programa mostrará una demostración completa de todas las funcionalidades implementadas.

---

## 10. Referencias

- Documentación oficial de Java: https://docs.oracle.com/javase/
- Principios de POO
- Convenciones de código Java

---

**Fin del Informe**
