package senac.tabalhao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.tabalhao.dto.PedidoDto;
import senac.tabalhao.entity.Cliente;
import senac.tabalhao.entity.Endereco;
import senac.tabalhao.entity.Pedido;
import senac.tabalhao.repository.PedidoRepositorio;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepositorio repository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    public Pedido create(PedidoDto pedidoDto) {
        Pedido pedido = new Pedido();

        Optional<Cliente> cliente = clienteService.pegarPorId(pedidoDto.clienteId());
        if (cliente.isEmpty()) {
            throw new IllegalArgumentException("Cliente de id " + pedidoDto.clienteId() + " não existente na base de dados");
        }

        Optional<Endereco> endereco = enderecoService.acharPorId(pedidoDto.enderecoId());
        if (endereco.isEmpty()) {
            throw new IllegalArgumentException("Endereço de id " + pedidoDto.enderecoId() + " não existente na base de dados");
        }

        pedido.setCliente(cliente.get());
        pedido.setEndereco(endereco.get());
        pedido.setDataCriacao(pedidoDto.dataCriacaoa());
        pedido.setValorTotal(pedidoDto.valorTotal());

        return repository.save(pedido);
    }

    public Pedido atualizar(Long id, PedidoDto pedidoDto) {
        Pedido pedido = buscarPorId(id).orElseThrow();

        pedido.setValorTotal(pedidoDto.valorTotal());
        pedido.setDataCriacao(pedidoDto.dataCriacaoa());

        return repository.save(pedido);
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return repository.findById(id);
    }
}
