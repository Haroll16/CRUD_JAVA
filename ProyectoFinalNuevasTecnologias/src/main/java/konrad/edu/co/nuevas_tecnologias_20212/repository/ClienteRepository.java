package konrad.edu.co.nuevas_tecnologias_20212.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import konrad.edu.co.nuevas_tecnologias_20212.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
