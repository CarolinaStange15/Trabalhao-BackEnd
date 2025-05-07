package senac.tabalhao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import senac.tabalhao.entity.PedidoItens;

public interface PedidoItensRepositorio extends JpaRepository <PedidoItens, Long> {

    @Query(value = "SELECT EXISTS (SELECT 1 FROM pedido_itens WHERE produto_id = :produtoId)",
           nativeQuery = true)
    boolean existsProdutoEmPedidoItem(@Param("produtoId") Long produtoId);

    @Modifying
    @Query(value = "DELETE FROM pedido_itens WHERE produto_id = :itemId AND pedidos_id = :pedidoId",
           nativeQuery = true)
    void deleteItemFromProduto(@Param("pedidoId") Long pedidoId,
                               @Param("itemId") Long itemId);

    @Query(value = """
        SELECT * FROM pedido_itens\s
        WHERE pedidos_id = :pedidoId AND produto_id = :produtoId
       \s""", nativeQuery = true)
    PedidoItens buscarPorPedidoEProduto(
            @Param("pedidoId") Long pedidoId,
            @Param("produtoId") Long produtoId
    );
}
