package senac.tabalhao.entity;

import jakarta.persistence.*;

@Entity
public class PedidoItens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    private double valorUnitario;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(double valorUnitario) { this.valorUnitario = valorUnitario; }

    //Relacionamentos

    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private Pedido pedido;

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    @ManyToOne
    private Produto produto;

    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }



}
