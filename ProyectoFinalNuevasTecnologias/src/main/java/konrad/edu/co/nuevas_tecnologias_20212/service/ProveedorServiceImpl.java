package konrad.edu.co.nuevas_tecnologias_20212.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konrad.edu.co.nuevas_tecnologias_20212.entity.Proveedor;
import konrad.edu.co.nuevas_tecnologias_20212.repository.ProveedorRepository;

/**
 *
 * @author ASUS
 */
@Service
public class ProveedorServiceImpl implements IProveedorService{
	@Autowired
	private ProveedorRepository provedorRepository;

	@Override
	public List<Proveedor> listarTodos() {
		return (List<Proveedor>) provedorRepository.findAll();
	}

	@Override
	public void guardar(Proveedor proveedor) {
		provedorRepository.save(proveedor);
		
	}

	@Override
	public Proveedor buscarPorId(Long nitProveedor) {
		return provedorRepository.findById(nitProveedor).orElse(null);
	}

	@Override
	public void eliminar(Long nitProveedor) {
		provedorRepository.deleteById(nitProveedor);
		
	}

	
}
