package senac.tabalhao.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataCriacao;
    private double valorTotal;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    //Relacionamentos
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    @OneToMany(mappedBy = "pedido")
    private List<PedidoItens> itens;

    public List<PedidoItens> getItens() { return itens; }
    public void setItens(List<PedidoItens> itens) { this.itens = itens; }


    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

//Falta o @OneToMany


}
