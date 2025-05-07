package senac.tabalhao.dto;

import java.util.Date;

public record PedidoDto(
        Date dataCriacaoa,
        double valorTotal,
        Long clienteId,
        Long enderecoId
) {
}
