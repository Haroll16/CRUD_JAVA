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

import konrad.edu.co.nuevas_tecnologias_20212.entity.Proveedor;
import konrad.edu.co.nuevas_tecnologias_20212.service.IProveedorService;

@Controller
@RequestMapping("/views/proveedores")
public class ProveedorController {

	@Autowired
	private IProveedorService proveedorService;

	@GetMapping("/")
	public String listarProveedor(Model model) {
		List<Proveedor> listadoProveedor = proveedorService.listarTodos();

		model.addAttribute("titulo", "Lista de Proveedores");
		model.addAttribute("Proveedor", listadoProveedor);

		return "/views/proveedores/listar";
	}

	@GetMapping("/create")
	public String crear(Model model, RedirectAttributes attribute) {

		Proveedor proveedor = new Proveedor();

		model.addAttribute("titulo", "Formulario: Nuevo Proveedor");
		model.addAttribute("proveedor", proveedor);

		return "/views/proveedores/frmCrear";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Proveedor proveedor, RedirectAttributes attribute) {

		proveedorService.guardar(proveedor);
		System.out.println("Proveedor guardado exitosamente");
		attribute.addFlashAttribute("success", "Proveedor guardado exitosamente");
		return "redirect:/views/proveedores/";
	}

	
	
	@GetMapping("/edit/{nitProveedor}")
	public String editar(@PathVariable("nitProveedor") Long nitProveedor, Model model, RedirectAttributes attribute) {
			
		Proveedor proveedor = null;
		
		if (nitProveedor > 0) {
			proveedor = proveedorService.buscarPorId(nitProveedor);
			
			if (proveedor == null) {
				System.out.println("Error: El nit del proveedor no existe");
				attribute.addFlashAttribute("error", "ATENCION: El nit del proveedor no existe");
				return "redirect:/views/proveedores/";
			}
		}else {
			System.out.println("Error: Error con el nit del proveedor");
			attribute.addFlashAttribute("error", "ATENCION: Error con el nit del proveedor");
			return "redirect:/views/proveedores/";
		}
		

		model.addAttribute("titulo", "Formulario: Editar Proveedor");
		model.addAttribute("proveedor", proveedor);

		return "/views/proveedores/frmCrear";
	}


	
	@GetMapping("/delete/{nitProveedor}")
	public String eliminar(@PathVariable("nitProveedor") Long nitProveedor, RedirectAttributes attribute) {

		Proveedor proveedor = null;
		
		if (nitProveedor > 0) {
			proveedor = proveedorService.buscarPorId(nitProveedor);
			
			if (proveedor == null) {
				System.out.println("Error: El nit del proveedor no existe");
				attribute.addFlashAttribute("error", "ATENCION: El nit del proveedor no existe");
				return "redirect:/views/proveedores/";
			}
		}else {
			System.out.println("Error: Error con el nit del proveedor");
			attribute.addFlashAttribute("error", "ATENCION: Error con el nit del proveedor");
			return "redirect:/views/proveedores/";
		}		
		
		proveedorService.eliminar(nitProveedor);
		System.out.println("Registro eliminado exitosamente");
		attribute.addFlashAttribute("warning", "Registro eliminado exitosamente");
		return "redirect:/views/proveedores/";
	}
}

