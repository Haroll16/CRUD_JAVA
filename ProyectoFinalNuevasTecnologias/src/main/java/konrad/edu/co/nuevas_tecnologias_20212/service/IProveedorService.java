package konrad.edu.co.nuevas_tecnologias_20212.service;

import java.util.List;

import konrad.edu.co.nuevas_tecnologias_20212.entity.Proveedor;

public interface IProveedorService {
	
	public List<Proveedor> listarTodos();
	public void guardar(Proveedor proveedor);
	public Proveedor buscarPorId(Long nitProveedor);
	public void eliminar(Long nitProveedor);
	
}
