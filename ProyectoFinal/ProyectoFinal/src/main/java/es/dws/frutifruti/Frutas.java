package es.dws.frutifruti;

import java.util.Arrays;

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

    List<Frutas> frutas = Arrays.asList(
        new Frutas("Platanos", 2.99, 20),
        new Frutas("Manzanas", 4.99, 20),
        new Frutas("Frambuesas", 4.99, 20),
        new Frutas("Albaricoques", 5.99, 20),
        new Frutas("Uvas", 9.99, 20),
        new Frutas("Naranjas", 3.99, 20)
    );
}
