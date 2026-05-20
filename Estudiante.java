import java.util.ArrayList;

public class Estudiante {
    // Atributos privados (encapsulamiento)
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private double promedio;
    private ArrayList<Materia> materias; // Relación con Materia

    // Constructor sin parámetros (predeterminado)
    public Estudiante() {
        this.materias = new ArrayList<>();
    }

    // Constructor con parámetros
    public Estudiante(String nombre, String apellido, int edad, String carrera, double promedio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
        this.promedio = promedio;
        this.materias = new ArrayList<>();
    }

    // Getters y Setters con validaciones

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío");
            return;
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            System.out.println("Error: El apellido no puede estar vacío");
            return;
        }
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad <= 16) {
            System.out.println("Error: La edad debe ser mayor a 16 años");
            return;
        }
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        if (promedio < 0 || promedio > 10) {
            System.out.println("Error: El promedio debe estar entre 0 y 10");
            return;
        }
        this.promedio = promedio;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    // Método para agregar una materia al estudiante
    public void agregarMateria(Materia materia) {
        if (materia != null) {
            this.materias.add(materia);
            System.out.println("Materia '" + materia.getNombre() + "' agregada al estudiante " + 
                             this.nombre + " " + this.apellido);
        } else {
            System.out.println("Error: No se puede agregar una materia nula");
        }
    }

    // Método para calcular el promedio de calificaciones de todas las materias
    public double calcularPromedio() {
        if (materias.isEmpty()) {
            System.out.println("El estudiante no tiene materias registradas");
            return 0.0;
        }

        double suma = 0;
        for (Materia materia : materias) {
            suma += materia.getCalificacion();
        }

        double promedioCalculado = suma / materias.size();
        this.promedio = promedioCalculado; // Actualizar el atributo promedio
        return promedioCalculado;
    }

    // Método para mostrar todas las materias del estudiante
    public void mostrarMaterias() {
        if (materias.isEmpty()) {
            System.out.println("El estudiante no tiene materias registradas");
            return;
        }

        System.out.println("\nMaterias de " + nombre + " " + apellido + ":");
        for (Materia materia : materias) {
            System.out.println("  - " + materia.toString());
        }
    }

    @Override
    public String toString() {
        return "Estudiante: " + nombre + " " + apellido + 
               " - Edad: " + edad + 
               " - Carrera: " + carrera + 
               " - Promedio: " + String.format("%.2f", promedio);
    }
}
