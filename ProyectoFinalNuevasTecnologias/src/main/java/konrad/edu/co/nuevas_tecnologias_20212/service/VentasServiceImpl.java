package konrad.edu.co.nuevas_tecnologias_20212.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import konrad.edu.co.nuevas_tecnologias_20212.entity.Ventas;
import konrad.edu.co.nuevas_tecnologias_20212.repository.VentasRepository;

/**
 *
 * @author ASUS
 */
@Service
public class VentasServiceImpl implements IVentasService{
	@Autowired
	private VentasRepository ventasRepository;

	@Override
	public List<Ventas> listarTodos() {
		return (List<Ventas>) ventasRepository.findAll();
	}

	@Override
	public void guardar(Ventas ventas) {
		ventasRepository.save(ventas);
		
	}

	@Override
	public Ventas buscarPorId(Long codigoVenta) {
		return ventasRepository.findById(codigoVenta).orElse(null);
	}

	@Override
	public void eliminar(Long codigoVenta) {
		ventasRepository.deleteById(codigoVenta);
		
	}

	
}