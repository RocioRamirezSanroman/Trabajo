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
   
	 @GetMapping("/index")
	 public String irIndex() {
		 return "index"; 
	 }	
		
	 @GetMapping("/shop")
	 public String irTienda() {
	     return "shop"; 
	 }
	 
	 @GetMapping("/cart")
	 public String irCarrito() {
	     return "cart"; 
	 }
	 
	 @GetMapping("/chackout")
	 public String irPago() {
	     return "chackout"; 
	 }
	 
}