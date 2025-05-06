package senac.tabalhao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.tabalhao.entity.Cliente;
import senac.tabalhao.repository.ClienteRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepositorio clienteRepositorio;

    public List<Cliente> listarClientes() {return clienteRepositorio.findAll(); }

    public Cliente criar(Cliente cliente) {
           if (cliente.getNome() == null || cliente.getSobrenome() == null || cliente.getDocumento() == null || cliente.getEmail() == null ){
               throw new IllegalArgumentException("Os campos obrigatórios não podem ser nulos!");
           }
        return clienteRepositorio.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        Optional<Cliente> existente = clienteRepositorio.findById(id);
        if (existente.isEmpty()){
            throw new IllegalArgumentException("O ID desse cliente não foi identificado!");
        }
        cliente.setId(id);
        return clienteRepositorio.save(cliente);
    }

    public void excluir(Long id){
        if (!clienteRepositorio.existsById(id)) {
            throw new IllegalArgumentException("Não existe cliente com esse ID!");
        }
        clienteRepositorio.deleteById(id);
    }
}
