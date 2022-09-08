package konrad.edu.co.nuevas_tecnologias_20212.service;

import java.util.List;

import konrad.edu.co.nuevas_tecnologias_20212.entity.Ventas;

public interface IVentasService {
	
	public List<Ventas> listarTodos();
	public void guardar(Ventas ventas);
	public Ventas buscarPorId(Long id);
	public void eliminar(Long id);
	
}

