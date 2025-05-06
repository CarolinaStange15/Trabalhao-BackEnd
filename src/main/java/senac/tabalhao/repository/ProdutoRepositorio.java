package senac.tabalhao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.tabalhao.entity.Produto;

public interface ProdutoRepositorio extends JpaRepository <Produto, Long> {
}
