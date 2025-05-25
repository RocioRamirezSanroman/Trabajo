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
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id_Ususario;
    String nombre;
    String contraseña;
    String correo;
    String direccion;
    Integer telefono;
    

    public Usuario(String nombre, String contraseña, String correo, String direccion, Integer telefono)
    {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        
    }

    @OneToMany(mappedBy="usuario")
    private List<Carrito> carrito;
    
}
