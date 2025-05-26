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
public class Verduras {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id_verdura;
    String nombre;
    double precio;
    double cantidad;


    public Verduras(String nombre, double precio, Integer cantidad)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    List<Verduras> verduras = Arrays.asList(
        new Verduras("Pepinos", 7.99, 20),
        new Verduras("Patatas", 4.99, 20),
        new Verduras("Pimientos", 6.99, 20),
        new Verduras("Perejil", 1.99, 20),
        new Verduras("Zanahorias", 5.99, 20),
        new Verduras("Brocoli", 4.99, 20)
    );
}
