package senac.tabalhao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senac.tabalhao.dto.PedidoItensDto;
import senac.tabalhao.entity.PedidoItens;
import senac.tabalhao.service.PedidoItensService;

@RestController
@RequestMapping(path = "/pedido/{pedidoId}/itens")
public class PedidoItensController {

    @Autowired
    private PedidoItensService service;

    @PostMapping
    public ResponseEntity<PedidoItens> adicionarItens(@PathVariable Long pedidoId,
                                                      @RequestBody PedidoItensDto pedidoItensDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarItem(pedidoId, pedidoItensDto));
    }

    @PutMapping(path = "/{itemId}")
    public ResponseEntity<PedidoItens> atualizar(@PathVariable Long pedidoId,
                                                 @PathVariable Long itemId,
                                                 @RequestBody PedidoItensDto pedidoItensDto) {
        return ResponseEntity.ok(service.atualizar(pedidoId, itemId, pedidoItensDto));
    }

    @DeleteMapping(path = "/{itemId}")
    public ResponseEntity<Void> removerItem(@PathVariable Long pedidoId,
                                            @PathVariable Long itemId) {
        service.removerItemDePedido(pedidoId, itemId);
        return ResponseEntity.noContent().build();
    }
}
