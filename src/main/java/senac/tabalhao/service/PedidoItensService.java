package senac.tabalhao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.tabalhao.dto.PedidoItensDto;
import senac.tabalhao.entity.Pedido;
import senac.tabalhao.entity.PedidoItens;
import senac.tabalhao.entity.Produto;
import senac.tabalhao.exception.PedidoNaoEncontradoException;
import senac.tabalhao.exception.ProdutoNaoEncontradoException;
import senac.tabalhao.repository.PedidoItensRepositorio;

@Service
public class PedidoItensService {

    @Autowired
    private PedidoItensRepositorio repositorio;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProdutoService produtoService;

    public PedidoItens adicionarItem(Long pedidoId, PedidoItensDto pedidoItensDto) {
        Pedido pedido = pedidoService.buscarPorId(pedidoId)
                .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado!"));

        Produto produto = produtoService.buscarPorId(pedidoItensDto.produtoId())
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado!"));

        PedidoItens pedidoItens = new PedidoItens();
        pedidoItens.setPedido(pedido);
        pedidoItens.setProduto(produto);
        pedidoItens.setQuantidade(pedidoItensDto.quantidade());
        pedidoItens.setValorUnitario(pedidoItensDto.valorUnitario());

        return repositorio.save(pedidoItens);
    }

    public PedidoItens atualizar(Long pedidoId, Long itemId, PedidoItensDto pedidoItensDto) {
        PedidoItens pedidoItens = repositorio.buscarPorPedidoEProduto(pedidoId, itemId);
        pedidoItens.setValorUnitario(pedidoItensDto.valorUnitario());
        pedidoItens.setQuantidade(pedidoItensDto.quantidade());

        return repositorio.save(pedidoItens);
    }

    public void removerItemDePedido(Long pedidoId, Long itemId) {
        repositorio.deleteItemFromProduto(pedidoId, itemId);
    }

    public boolean produtoEstaEmPedido(Long idProduto) {
        return repositorio.existsProdutoEmPedidoItem(idProduto);
    }
}
