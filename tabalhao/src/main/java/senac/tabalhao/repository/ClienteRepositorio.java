package senac.tabalhao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.tabalhao.entity.Cliente;

public interface ClienteRepositorio extends JpaRepository <Cliente, Long> {
}
