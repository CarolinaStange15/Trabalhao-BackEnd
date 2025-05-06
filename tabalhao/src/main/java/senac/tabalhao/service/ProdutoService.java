package senac.tabalhao.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.tabalhao.entity.Produto;
import senac.tabalhao.repository.ProdutoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepositorio produtoRepositorio;

    public List<Produto> listarProdutos() {return produtoRepositorio.findAll();}

    public Produto criar(Produto produto) {
        if (produto.getNome() == null){
            throw new IllegalArgumentException("Você deve cadastrar um nome para o produto!");
        }
        return produtoRepositorio.save(produto);
    }

    public Produto atualizar(Long id, Produto produto) {
        Optional<Produto> existente = produtoRepositorio.findById(id);
        if (existente.isEmpty()){
            throw new IllegalArgumentException("O ID desse produto não foi identificado!");
        }
        produto.setId(id);
        return produtoRepositorio.save(produto);
    }

    public void excluir(Long id){
        if (!produtoRepositorio.existsById(id)) {
            throw new IllegalArgumentException("Não existe nenhum produto com esse ID!");
        }
        produtoRepositorio.deleteById(id);
    }


}
