# Trabajo Práctico 0 - Programación Orientada a Objetos

Sistema de gestión académica implementado en Java que demuestra los conceptos fundamentales de POO.

## 📋 Contenido

- **Estudiante.java** - Clase que representa un estudiante con materias
- **Materia.java** - Clase que representa una materia académica
- **Carrera.java** - Clase que gestiona estudiantes de una carrera
- **Universidad.java** - Clase que gestiona carreras y estudiantes
- **App.java** - Clase principal con demostración completa
- **INFORME.md** - Informe detallado del trabajo práctico

## 🎯 Características Implementadas

### ✅ Encapsulamiento
- Todos los atributos son privados
- Acceso controlado mediante getters y setters
- Validaciones en todos los setters

### ✅ Relaciones entre Clases
- **Estudiante ↔ Materia**: Un estudiante tiene múltiples materias
- **Carrera ↔ Estudiante**: Una carrera tiene múltiples estudiantes
- **Universidad ↔ Carrera/Estudiante**: Una universidad gestiona carreras y estudiantes

### ✅ Validaciones
- Edad mayor a 16 años
- Promedio entre 0 y 10
- Nombres y apellidos no vacíos
- Créditos mayores a 0
- Calificaciones entre 0 y 10

## 🚀 Cómo Ejecutar

### Compilar

```bash
javac *.java
```

### Ejecutar

```bash
java App
```

## 📊 Salida Esperada

El programa mostrará:

1. Creación de estudiantes usando ambos constructores
2. Demostración de validaciones con mensajes de error
3. Creación de una carrera y adición de estudiantes
4. Asignación de materias a estudiantes
5. Cálculo automático de promedios
6. Búsqueda de estudiantes
7. Gestión completa de universidad
8. Resumen de funcionalidades implementadas

## 📝 Estructura de Clases

```
Universidad
    ├── Carrera (múltiples)
    │   └── Estudiante (múltiples)
    │       └── Materia (múltiples)
    └── Estudiante (múltiples)
```

## 🔍 Conceptos de POO Demostrados

1. **Clases y Objetos**: Definición de plantillas y creación de instancias
2. **Constructores**: Sin parámetros y con parámetros
3. **Encapsulamiento**: Atributos privados con getters/setters
4. **Palabra clave `this`**: Referencia al objeto actual
5. **Operador punto**: Acceso a métodos y atributos
6. **Relaciones**: Agregación entre clases
7. **Colecciones**: Uso de ArrayList para relaciones uno-a-muchos

## 📄 Documentación

Para más detalles sobre la implementación, consulta el archivo [INFORME.md](INFORME.md).

## 👨‍💻 Autor

Walter Molina - Algoritmos y Estructuras de Datos II

## 📅 Fecha

Mayo 2026
