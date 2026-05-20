public class Materia {
    // Atributos privados (encapsulamiento)
    private String nombre;
    private String codigo;
    private int creditos;
    private double calificacion;

    // Constructor sin parámetros (predeterminado)
    public Materia() {
    }

    // Constructor con parámetros
    public Materia(String nombre, String codigo, int creditos, double calificacion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.calificacion = calificacion;
    }

    // Getters y Setters con validaciones

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre de la materia no puede estar vacío");
            return;
        }
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("Error: El código de la materia no puede estar vacío");
            return;
        }
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        if (creditos <= 0) {
            System.out.println("Error: Los créditos deben ser mayores a 0");
            return;
        }
        this.creditos = creditos;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        if (calificacion < 0 || calificacion > 10) {
            System.out.println("Error: La calificación debe estar entre 0 y 10");
            return;
        }
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Materia: " + nombre + " (" + codigo + ") - Créditos: " + creditos + 
               " - Calificación: " + calificacion;
    }
}
