package senac.tabalhao.dto;

import java.util.List;

public record PedidoItensDto(
        Long produtoId,
        int quantidade,
        double valorUnitario
) {
}
