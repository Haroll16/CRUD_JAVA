package konrad.edu.co.nuevas_tecnologias_20212.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import konrad.edu.co.nuevas_tecnologias_20212.entity.Ventas;
import konrad.edu.co.nuevas_tecnologias_20212.service.IVentasService;

@Controller
@RequestMapping("/views/ventas")
public class VentasController {

	@Autowired
	private IVentasService ventasService;

	@GetMapping("/")
	public String listarCliente(Model model) {
		List<Ventas> listadoVentas = ventasService.listarTodos();

		model.addAttribute("titulo", "Lista de Ventas");
		model.addAttribute("ventas", listadoVentas);

		return "/views/ventas/listar";
	}

	@GetMapping("/create")
	public String crear(Model model, RedirectAttributes attribute) {

		Ventas ventas = new Ventas();

		model.addAttribute("titulo", "Formulario: Nueva Venta");
		model.addAttribute("ventas", ventas);

		return "/views/ventas/frmCrear";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Ventas ventas, RedirectAttributes attribute) {

		ventasService.guardar(ventas);
		System.out.println("Venta guardada exitosamente");
		attribute.addFlashAttribute("success", "Venta guardada exitosamente");
		return "redirect:/views/ventas/";
	}

	
	
	
	@GetMapping("/edit/{codigo}")
	public String editar(@PathVariable("codigo") Long codigo, Model model, RedirectAttributes attribute) {
			
		Ventas venta = null;
		
		if (codigo > 0) {
			venta = ventasService.buscarPorId(codigo);
			
			if (venta == null) {
				System.out.println("Error: El código de la venta no existe");
				attribute.addFlashAttribute("error", "ATENCION: El código de la venta no existe");
				return "redirect:/views/ventas/";
			}
		}else {
			System.out.println("Error: Error con el código de la venta");
			attribute.addFlashAttribute("error", "ATENCION: Error con el código de la venta");
			return "redirect:/views/ventas/";
		}
		

		model.addAttribute("titulo", "Formulario: Editar Venta");
		model.addAttribute("ventas", venta);

		return "/views/ventas/frmCrear";
	}


	
	@GetMapping("/delete/{codigo}")
	public String eliminar(@PathVariable("codigo") Long codigo, RedirectAttributes attribute) {

		Ventas venta  = null;
		
		if (codigo > 0) {
			venta = ventasService.buscarPorId(codigo);
			
			if (venta == null) {
				System.out.println("Error: El código de la venta no existe");
				attribute.addFlashAttribute("error", "ATENCION: El código de la venta no existe");
				return "redirect:/views/ventas/";
			}
		}else {
			System.out.println("Error: Error con el código de la venta");
			attribute.addFlashAttribute("error", "ATENCION: Error con el código de la venta");
			return "redirect:/views/ventas/";
		}		
		
		ventasService.eliminar(codigo);
		System.out.println("Registro eliminado exitosamente");
		attribute.addFlashAttribute("warning", "Registro eliminado exitosamente");
		return "redirect:/views/ventas/";
	}
}