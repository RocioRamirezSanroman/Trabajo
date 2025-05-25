package es.dws.frutifruti;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
@NoArgsConstructor
public class Carrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id_carrito;
    
    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Verduras verduras;

    @ManyToOne
    private Frutas frutas;
}
