package senac.tabalhao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.tabalhao.entity.Pedido;
import senac.tabalhao.entity.PedidoItens;

public interface PedidoItensRepositorio extends JpaRepository <PedidoItens, Long> {
}
