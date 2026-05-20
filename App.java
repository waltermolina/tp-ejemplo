public class App {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("    TRABAJO PRÁCTICO - PROGRAMACIÓN ORIENTADA A OBJETOS");
        System.out.println("=================================================\n");

        // ============================================
        // PARTE 1: Creación básica de estudiantes
        // ============================================
        System.out.println("--- PARTE 1: Creación de Estudiantes ---\n");

        // Creación de arreglo de estudiantes
        Estudiante[] arregloEstudiantes = new Estudiante[3];

        // Estudiante 1: usando constructor sin parámetros
        arregloEstudiantes[0] = new Estudiante();
        arregloEstudiantes[0].setNombre("Juan");
        arregloEstudiantes[0].setApellido("Pérez");
        arregloEstudiantes[0].setEdad(20);
        arregloEstudiantes[0].setCarrera("Ingeniería en Sistemas");
        arregloEstudiantes[0].setPromedio(8.5);

        // Estudiante 2: usando constructor con parámetros
        arregloEstudiantes[1] = new Estudiante("María", "González", 22, "Ingeniería en Sistemas", 9.2);

        // Estudiante 3: usando constructor con parámetros
        arregloEstudiantes[2] = new Estudiante("Carlos", "Rodríguez", 21, "Ingeniería en Sistemas", 7.8);

        // Recorrer el arreglo e imprimir nombre y promedio
        System.out.println("Estudiantes creados (usando arreglo):");
        for (int i = 0; i < arregloEstudiantes.length; i++) {
            System.out.println("  - Nombre: " + arregloEstudiantes[i].getNombre() + 
                             " " + arregloEstudiantes[i].getApellido() + 
                             " | Promedio: " + arregloEstudiantes[i].getPromedio());
        }

        // ============================================
        // PARTE 2: Validaciones de Encapsulamiento
        // ============================================
        System.out.println("\n--- PARTE 2: Demostración de Validaciones ---\n");

        Estudiante estudianteTest = new Estudiante();
        
        // Intentar establecer edad menor a 16
        System.out.println("Intentando establecer edad de 15 años:");
        estudianteTest.setEdad(15);
        
        // Intentar establecer promedio fuera de rango
        System.out.println("\nIntentando establecer promedio de 11:");
        estudianteTest.setPromedio(11);
        
        // Intentar establecer nombre vacío
        System.out.println("\nIntentando establecer nombre vacío:");
        estudianteTest.setNombre("");

        // Valores válidos
        System.out.println("\nEstableciendo valores válidos:");
        estudianteTest.setNombre("Ana");
        estudianteTest.setApellido("Martínez");
        estudianteTest.setEdad(19);
        estudianteTest.setPromedio(8.7);
        System.out.println("✓ Estudiante creado correctamente: " + estudianteTest.getNombre() + 
                         " " + estudianteTest.getApellido());

        // ============================================
        // PARTE 3: Relaciones entre Clases
        // ============================================
        System.out.println("\n--- PARTE 3: Relaciones entre Clases ---\n");

        // Crear una carrera
        Carrera ingenieriaEnSistemas = new Carrera("Ingeniería en Sistemas", "IS-001", 5);
        System.out.println("Carrera creada: " + ingenieriaEnSistemas.getNombre() + "\n");

        // Agregar estudiantes a la carrera
        System.out.println("Agregando estudiantes a la carrera:");
        ingenieriaEnSistemas.agregarEstudiante(arregloEstudiantes[0]);
        ingenieriaEnSistemas.agregarEstudiante(arregloEstudiantes[1]);
        ingenieriaEnSistemas.agregarEstudiante(arregloEstudiantes[2]);
        ingenieriaEnSistemas.agregarEstudiante(estudianteTest);

        // ============================================
        // PARTE 4: Materias y Relaciones
        // ============================================
        System.out.println("\n--- PARTE 4: Materias y Cálculo de Promedios ---\n");

        // Crear materias para el primer estudiante (Juan)
        Materia algebra = new Materia("Álgebra y Geometría Analítica", "MAT101", 6, 8.5);
        Materia programacion = new Materia("Programación I", "INF102", 8, 9.0);
        Materia fisica = new Materia("Física I", "FIS103", 6, 8.0);

        System.out.println("Asignando materias a " + arregloEstudiantes[0].getNombre() + ":");
        arregloEstudiantes[0].agregarMateria(algebra);
        arregloEstudiantes[0].agregarMateria(programacion);
        arregloEstudiantes[0].agregarMateria(fisica);

        // Mostrar materias del estudiante
        arregloEstudiantes[0].mostrarMaterias();

        // Calcular promedio automático
        System.out.println("\nCalculando promedio de " + arregloEstudiantes[0].getNombre() + ":");
        double promedioCalculado = arregloEstudiantes[0].calcularPromedio();
        System.out.println("Promedio calculado: " + String.format("%.2f", promedioCalculado));

        // Crear materias para María
        System.out.println("\n" + "=".repeat(50));
        Materia analisis = new Materia("Análisis Matemático", "MAT201", 6, 9.5);
        Materia estructuras = new Materia("Estructuras de Datos", "INF201", 8, 9.0);
        Materia baseDatos = new Materia("Base de Datos I", "INF202", 6, 9.2);

        System.out.println("Asignando materias a " + arregloEstudiantes[1].getNombre() + ":");
        arregloEstudiantes[1].agregarMateria(analisis);
        arregloEstudiantes[1].agregarMateria(estructuras);
        arregloEstudiantes[1].agregarMateria(baseDatos);
        
        arregloEstudiantes[1].mostrarMaterias();
        promedioCalculado = arregloEstudiantes[1].calcularPromedio();
        System.out.println("Promedio calculado: " + String.format("%.2f", promedioCalculado));

        // Crear materias para Carlos
        System.out.println("\n" + "=".repeat(50));
        Materia discreta = new Materia("Matemática Discreta", "MAT301", 6, 7.5);
        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos", "INF301", 8, 8.0);
        Materia arquitectura = new Materia("Arquitectura de Computadoras", "INF302", 6, 8.0);

        System.out.println("Asignando materias a " + arregloEstudiantes[2].getNombre() + ":");
        arregloEstudiantes[2].agregarMateria(discreta);
        arregloEstudiantes[2].agregarMateria(algoritmos);
        arregloEstudiantes[2].agregarMateria(arquitectura);
        
        arregloEstudiantes[2].mostrarMaterias();
        promedioCalculado = arregloEstudiantes[2].calcularPromedio();
        System.out.println("Promedio calculado: " + String.format("%.2f", promedioCalculado));

        // ============================================
        // PARTE 5: Listar todos los estudiantes de la carrera
        // ============================================
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\n--- PARTE 5: Listado de Estudiantes por Carrera ---");
        ingenieriaEnSistemas.listarEstudiantes();

        // Mostrar promedio general de la carrera
        System.out.println("Promedio general de la carrera: " + 
                         String.format("%.2f", ingenieriaEnSistemas.obtenerPromedioGeneral()));

        // ============================================
        // PARTE 6: Búsqueda de estudiante
        // ============================================
        System.out.println("\n--- PARTE 6: Búsqueda de Estudiante ---\n");
        System.out.println("Buscando estudiante por nombre 'María':");
        Estudiante encontrado = ingenieriaEnSistemas.buscarEstudiante("María");
        
        if (encontrado != null) {
            System.out.println("\nDetalles del estudiante encontrado:");
            System.out.println("  Nombre completo: " + encontrado.getNombre() + " " + encontrado.getApellido());
            System.out.println("  Edad: " + encontrado.getEdad() + " años");
            System.out.println("  Promedio: " + String.format("%.2f", encontrado.getPromedio()));
            System.out.println("  Cantidad de materias: " + encontrado.getMaterias().size());
        }

        System.out.println("\nBuscando estudiante inexistente 'Pedro':");
        ingenieriaEnSistemas.buscarEstudiante("Pedro");

        // ============================================
        // PARTE 7: Universidad
        // ============================================
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\n--- PARTE 7: Gestión de Universidad ---\n");

        Universidad unlp = new Universidad("Universidad Nacional de La Plata", 
                                          "Calle 7 entre 47 y 48, La Plata");
        
        System.out.println("Universidad creada:");
        System.out.println(unlp.toString());

        // Agregar la carrera a la universidad
        System.out.println("\nAgregando carrera a la universidad:");
        unlp.agregarCarrera(ingenieriaEnSistemas);

        // Agregar estudiantes a la universidad
        System.out.println("\nAgregando estudiantes a la universidad:");
        for (Estudiante est : arregloEstudiantes) {
            unlp.agregarEstudiante(est);
        }
        unlp.agregarEstudiante(estudianteTest);

        // Listar información de la universidad
        unlp.listarCarreras();
        unlp.listarEstudiantes();

        // ============================================
        // RESUMEN FINAL
        // ============================================
        System.out.println("=".repeat(50));
        System.out.println("             RESUMEN FINAL");
        System.out.println("=".repeat(50));
        System.out.println("✓ Clases implementadas: Estudiante, Materia, Carrera, Universidad");
        System.out.println("✓ Encapsulamiento aplicado con getters/setters y validaciones");
        System.out.println("✓ Relaciones entre clases implementadas:");
        System.out.println("  - Estudiante tiene múltiples Materias (agregación)");
        System.out.println("  - Carrera tiene múltiples Estudiantes (agregación)");
        System.out.println("  - Universidad tiene múltiples Estudiantes y Carreras (agregación)");
        System.out.println("✓ Métodos de gestión implementados:");
        System.out.println("  - agregarMateria(), calcularPromedio() en Estudiante");
        System.out.println("  - agregarEstudiante(), listarEstudiantes(), buscarEstudiante() en Carrera");
        System.out.println("✓ Validaciones activas en setters para edad, promedio y textos vacíos");
        System.out.println("=".repeat(50));
        System.out.println("\n¡Trabajo práctico completado exitosamente!");
    }
}
