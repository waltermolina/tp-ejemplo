import java.util.ArrayList;

public class Universidad {
    // Atributos privados (encapsulamiento)
    private String nombre;
    private String direccion;
    private ArrayList<Estudiante> estudiantes; // Relación con Estudiante
    private ArrayList<Carrera> carreras;

    // Constructor sin parámetros
    public Universidad() {
        this.estudiantes = new ArrayList<>();
        this.carreras = new ArrayList<>();
    }

    // Constructor con parámetros
    public Universidad(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estudiantes = new ArrayList<>();
        this.carreras = new ArrayList<>();
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre de la universidad no puede estar vacío");
            return;
        }
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            System.out.println("Error: La dirección no puede estar vacía");
            return;
        }
        this.direccion = direccion;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    // Método para agregar un estudiante a la universidad
    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            this.estudiantes.add(estudiante);
            System.out.println("Estudiante " + estudiante.getNombre() + " " + 
                             estudiante.getApellido() + " agregado a la universidad " + this.nombre);
        } else {
            System.out.println("Error: No se puede agregar un estudiante nulo");
        }
    }

    // Método para agregar una carrera a la universidad
    public void agregarCarrera(Carrera carrera) {
        if (carrera != null) {
            this.carreras.add(carrera);
            System.out.println("Carrera '" + carrera.getNombre() + "' agregada a la universidad");
        } else {
            System.out.println("Error: No se puede agregar una carrera nula");
        }
    }

    // Método para listar todos los estudiantes de la universidad
    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("La universidad no tiene estudiantes registrados");
            return;
        }

        System.out.println("\n=== Estudiantes de " + nombre + " ===");
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println("-----------------------------------------------");
        
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println((i + 1) + ". " + estudiantes.get(i).toString());
        }
        System.out.println("-----------------------------------------------\n");
    }

    // Método para listar todas las carreras
    public void listarCarreras() {
        if (carreras.isEmpty()) {
            System.out.println("La universidad no tiene carreras registradas");
            return;
        }

        System.out.println("\n=== Carreras de " + nombre + " ===");
        System.out.println("Total de carreras: " + carreras.size());
        System.out.println("-----------------------------------------------");
        
        for (int i = 0; i < carreras.size(); i++) {
            System.out.println((i + 1) + ". " + carreras.get(i).toString());
        }
        System.out.println("-----------------------------------------------\n");
    }

    @Override
    public String toString() {
        return "Universidad: " + nombre + 
               "\nDirección: " + direccion + 
               "\nTotal estudiantes: " + estudiantes.size() + 
               "\nTotal carreras: " + carreras.size();
    }
}
