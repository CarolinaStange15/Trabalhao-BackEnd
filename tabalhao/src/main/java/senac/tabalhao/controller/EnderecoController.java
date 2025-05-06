package senac.tabalhao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import senac.tabalhao.entity.Endereco;
import senac.tabalhao.repository.EnderecoRepositorio;
import senac.tabalhao.service.EnderecoService;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping("/{clienteId}/listar")
    public List<Endereco> listarEnderecos(@PathVariable Long clienteId) {
        return service.listarEnderecosDoCliente(clienteId);
    }

    @PostMapping("/{clienteId}/criar")
    public Endereco criar(@PathVariable Long clienteId, @RequestBody Endereco endereco) {
        return service.criar(clienteId, endereco);
    }

    @PutMapping("/{clienteId}/atualizar/{id}")
    public Endereco atualizar(@PathVariable Long clienteId, @PathVariable Long id, @RequestBody Endereco endereco) {
        return service.atualizar(clienteId, id, endereco);
    }

    @DeleteMapping("/{clienteId}/excluir/{id}")
    public void excluir (@PathVariable Long clienteId, @PathVariable Long id){
        service.excluir(clienteId, id);
    }

}
