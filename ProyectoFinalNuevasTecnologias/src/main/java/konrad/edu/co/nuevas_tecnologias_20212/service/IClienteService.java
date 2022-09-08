package konrad.edu.co.nuevas_tecnologias_20212.service;

import java.util.List;

import konrad.edu.co.nuevas_tecnologias_20212.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> listarTodos();
	public void guardar(Cliente cliente);
	public Cliente buscarPorId(Long id);
	public void eliminar(Long id);
	
}
