package senac.tabalhao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.tabalhao.entity.Pedido;

public interface PedidoRepositorio extends JpaRepository <Pedido, Long> {
}
