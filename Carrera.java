import java.util.ArrayList;

public class Carrera {
    // Atributos privados
    private String nombre;
    private String codigo;
    private int duracionAnios;
    private ArrayList<Estudiante> estudiantes; // Relación con Estudiante

    // Constructor sin parámetros
    public Carrera() {
        this.estudiantes = new ArrayList<>();
    }

    // Constructor con parámetros
    public Carrera(String nombre, String codigo, int duracionAnios) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.duracionAnios = duracionAnios;
        this.estudiantes = new ArrayList<>();
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre de la carrera no puede estar vacío");
            return;
        }
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("Error: El código de la carrera no puede estar vacío");
            return;
        }
        this.codigo = codigo;
    }

    public int getDuracionAnios() {
        return duracionAnios;
    }

    public void setDuracionAnios(int duracionAnios) {
        if (duracionAnios <= 0) {
            System.out.println("Error: La duración debe ser mayor a 0");
            return;
        }
        this.duracionAnios = duracionAnios;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    // Método para agregar un estudiante a la carrera
    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            this.estudiantes.add(estudiante);
            // Actualizar la carrera del estudiante
            estudiante.setCarrera(this.nombre);
            System.out.println("Estudiante " + estudiante.getNombre() + " " + 
                             estudiante.getApellido() + " agregado a la carrera " + this.nombre);
        } else {
            System.out.println("Error: No se puede agregar un estudiante nulo");
        }
    }

    // Método para listar todos los estudiantes de la carrera
    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("La carrera " + nombre + " no tiene estudiantes registrados");
            return;
        }

        System.out.println("\n=== Estudiantes de la carrera: " + nombre + " ===");
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println("-----------------------------------------------");
        
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println((i + 1) + ". " + estudiantes.get(i).toString());
        }
        System.out.println("-----------------------------------------------\n");
    }

    // Método para buscar un estudiante por nombre
    public Estudiante buscarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre de búsqueda no puede estar vacío");
            return null;
        }

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre) || 
                estudiante.getApellido().equalsIgnoreCase(nombre)) {
                System.out.println("Estudiante encontrado: " + estudiante.toString());
                return estudiante;
            }
        }

        System.out.println("No se encontró ningún estudiante con el nombre: " + nombre);
        return null;
    }

    // Método para obtener el promedio general de la carrera
    public double obtenerPromedioGeneral() {
        if (estudiantes.isEmpty()) {
            return 0.0;
        }

        double suma = 0;
        for (Estudiante estudiante : estudiantes) {
            suma += estudiante.getPromedio();
        }

        return suma / estudiantes.size();
    }

    @Override
    public String toString() {
        return "Carrera: " + nombre + " (" + codigo + ") - Duración: " + 
               duracionAnios + " años - Estudiantes: " + estudiantes.size();
    }
}
