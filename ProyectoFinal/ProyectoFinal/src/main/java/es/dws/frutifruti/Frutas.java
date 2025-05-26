package es.dws.frutifruti;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity
@NoArgsConstructor
public class Frutas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id_fruta;
    String nombre;
    double precio;
    double cantidad;

    public Frutas(String nombre, double precio, Integer cantidad)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    List<Producto> productos = Arrays.asList(
        new Frutas('Platanos', 2.99, 20),
        new Frutas('Manzanas', 4.99, 20),
        new Frutas('Frambuesas', 4.99, 20),
        new Frutas('Albaricoques', 5.99, 20),
        new Frutas('Uvas', 9.99, 20),
        new Frutas('Naranjas', 3.99, 20)
    );

    @OneToMany(mappedBy="frutas")
    private List<Carrito> carrito;
}
