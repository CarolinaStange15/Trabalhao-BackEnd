package senac.tabalhao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import senac.tabalhao.entity.Cliente;
import senac.tabalhao.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/listar")
    public List<Cliente> listarCliente() { return service.listarClientes(); }

    @PostMapping("/criar")
    public Cliente criar(@RequestBody Cliente cliente) {return service.criar(cliente); }

    @PutMapping("/atualizar/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        return service.atualizar(id, cliente);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {service.excluir(id); }


    }
