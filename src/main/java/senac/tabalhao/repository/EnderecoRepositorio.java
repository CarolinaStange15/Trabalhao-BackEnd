package senac.tabalhao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.tabalhao.entity.Endereco;

import java.util.List;

public interface EnderecoRepositorio extends JpaRepository <Endereco, Long> {
    List<Endereco> findByClienteId(Long clienteId);
}
