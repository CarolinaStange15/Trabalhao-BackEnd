package senac.tabalhao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import senac.tabalhao.entity.Produto;
import senac.tabalhao.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/listar")
    public List<Produto> listarProduto() { return service.listarProdutos();}

    @PostMapping("/criar")
    public Produto criar(@RequestBody Produto produto) {
        return service.criar(produto); }

    @PutMapping("/atualizar/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return service.atualizar(id, produto);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
