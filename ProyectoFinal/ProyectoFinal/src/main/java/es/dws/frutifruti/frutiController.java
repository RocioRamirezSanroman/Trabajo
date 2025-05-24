package es.dws.frutifruti;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class frutiController {
	
	private List<Anuncio> anuncios = new ArrayList<>();
	
	public frutiController(){
		anuncios.add(new Anuncio("mario", 0,"Fresas"));
		anuncios.add(new Anuncio("antonio", 1,"Manzanas"));
		anuncios.add(new Anuncio("cris", 2,"Piñas"));		
	}
	
    @PostMapping("/guardarFormulario")
    public String guardarAnuncio(@RequestParam String nombre,
    							 @RequestParam int numero, 
    							 @RequestParam String comentario) 
    {	
    	Anuncio anuncio = new Anuncio(nombre, numero, comentario);
    	anuncios.add(anuncio);
        return "volver";  
    }
    
    @GetMapping("/pedidos")
    public String irPedido(@RequestParam int numero, Model model) {
        Anuncio anuncioEncontrado = anuncios.stream()
            .filter(a -> a.getNumero() == numero)
            .findFirst()
            .orElse(null);
        
        if (anuncioEncontrado != null) {
            model.addAttribute("anuncio", anuncioEncontrado);
            return "pedido";
        } else {
            model.addAttribute("errorMessage", "No se encontró el pedido con número: " + numero);
            return "error";
        }
    }
    
    @GetMapping("/")
    public String mostrarAnuncios(Model model){
    	model.addAttribute("anuncios", anuncios);
    	
		return "index";
    }
       
    @GetMapping("/formulario")
    public String irFormulario() {
        return "formulario"; 
    }
    

}