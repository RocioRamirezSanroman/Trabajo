package es.dws.frutifruti;

public class Inventario {
    private String nombre;
    private int numero;
    private String comentario;

    // Constructor con validaciones
    public Inventario(String nombre, int numero, String comentario) {
        this.nombre = nombre;
        this.numero = numero;
        this.comentario = comentario;
    }
    
    // Constructor vacío necesario para Spring
    public Inventario() {
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getComentario() {
        return comentario;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    // Método para mostrar información del anuncio
    @Override
    public String toString() {
        return "Anuncio: " + nombre + " | Número: " + numero + " | Comentario: " + comentario;
    }
}
