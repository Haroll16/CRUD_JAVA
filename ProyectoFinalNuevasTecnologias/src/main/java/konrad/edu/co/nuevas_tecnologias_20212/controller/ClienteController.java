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

import konrad.edu.co.nuevas_tecnologias_20212.entity.Cliente;
import konrad.edu.co.nuevas_tecnologias_20212.service.IClienteService;


@Controller
@RequestMapping("/views/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/")
	public String listarCliente(Model model) {
		List<Cliente> listadoCliente = clienteService.listarTodos();

		model.addAttribute("titulo", "Lista de Clientes");
		model.addAttribute("clientes", listadoCliente);

		return "/views/clientes/listar";
	}

	@GetMapping("/create")
	public String crear(Model model, RedirectAttributes attribute) {

		Cliente cliente = new Cliente();

		model.addAttribute("titulo", "Formulario: Nuevo Cliente");
		model.addAttribute("clientes", cliente);

		return "/views/clientes/frmCrear";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Cliente cliente, RedirectAttributes attribute) {

		clienteService.guardar(cliente);
		System.out.println("Cliente guardado exitosamente");
		attribute.addFlashAttribute("success", "Cliente guardado exitosamente");
		return "redirect:/views/clientes/";
	}

	

	
	@GetMapping("/edit/{cedula}")
	public String editar(@PathVariable("cedula") Long cedula, Model model, RedirectAttributes attribute) {
			
		Cliente cliente = null;
		
		if (cedula > 0) {
			cliente = clienteService.buscarPorId(cedula);
			
			if (cliente == null) {
				System.out.println("Error: La cédula del cliente no existe");
				attribute.addFlashAttribute("error", "ATENCION: La cédula del cliente no existe");
				return "redirect:/views/clientes/";
			}
		}else {
			System.out.println("Error: Error con la cédula del cliente");
			attribute.addFlashAttribute("error", "ATENCION: Error con la cédula del cliente");
			return "redirect:/views/clientes/";
		}
		

		model.addAttribute("titulo", "Formulario: Editar Cliente");
		model.addAttribute("clientes", cliente);

		return "/views/clientes/frmCrear";
	}


	
	@GetMapping("/delete/{cedula}")
	public String eliminar(@PathVariable("cedula") Long cedula, RedirectAttributes attribute) {

		Cliente cliente = null;
		
		if (cedula > 0) {
			cliente = clienteService.buscarPorId(cedula);
			
			if (cliente == null) {
				System.out.println("Error: La cédula del cliente no existe");
				attribute.addFlashAttribute("error", "ATENCION: La cédula del cliente no existe");
				return "redirect:/views/clientes/";
			}
		}else {
			System.out.println("Error: Error con la cédula del cliente");
			attribute.addFlashAttribute("error", "ATENCION: Error con la cédula del cliente");
			return "redirect:/views/clientes/";
		}		
		
		clienteService.eliminar(cedula);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro eliminado exitosamente");

		return "redirect:/views/clientes/";
	}
}


//LISTO IMPORTOAR 07/09/2022