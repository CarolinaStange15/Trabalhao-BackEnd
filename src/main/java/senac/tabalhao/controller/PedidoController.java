package senac.tabalhao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senac.tabalhao.dto.PedidoDto;
import senac.tabalhao.entity.Pedido;
import senac.tabalhao.service.PedidoService;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody PedidoDto pedidoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(pedidoDto));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Long id,
                                         @RequestBody PedidoDto pedidoDto) {
        return ResponseEntity.ok(service.atualizar(id, pedidoDto));
    }
}
