package senac.tabalhao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.tabalhao.entity.Cliente;
import senac.tabalhao.entity.Endereco;
import senac.tabalhao.repository.ClienteRepositorio;
import senac.tabalhao.repository.EnderecoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepositorio enderecoRepositorio;

    @Autowired
    ClienteRepositorio clienteRepositorio;


    public List<Endereco> listarEnderecosDoCliente(Long clienteId) {
        return enderecoRepositorio.findByClienteId(clienteId);
    }

    public Endereco criar(Long clienteId, Endereco endereco) {
        if (endereco.getCep() == 0 || endereco.getLogradouro() == null || endereco.getBairro() == null || endereco.getCidade() == null || endereco.getNumero() == null || endereco.getEstado() == null) {
            throw new IllegalArgumentException("Os campos obrigatórios não podem ser nulos!");
        }

        Cliente cliente = clienteRepositorio.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente com ID " + clienteId + " não encontrado."));

        endereco.setCliente(cliente);
        return enderecoRepositorio.save(endereco);
    }


    public Endereco atualizar(Long enderecoId, Long clienteId, Endereco enderecoAtualizado) {
        Optional<Endereco> existente = enderecoRepositorio.findById(enderecoId);

        if (existente.isEmpty() || !existente.get().getCliente().getId().equals(clienteId)) {
            throw new IllegalArgumentException("Não existe um endereço com esse ID associado a este cliente!");
        }

        enderecoAtualizado.setId(enderecoId);
        enderecoAtualizado.setCliente(existente.get().getCliente()); // garante que use o ID certo
        return enderecoRepositorio.save(enderecoAtualizado);
    }

    public void excluir(Long enderecoId, Long clienteId) {
        Optional<Endereco> endereco = enderecoRepositorio.findById(enderecoId);

        if (endereco.isEmpty() || !endereco.get().getCliente().getId().equals(clienteId)) {
            throw new IllegalArgumentException("Não existe um endereço com esse ID associado a este cliente!");
        }
        enderecoRepositorio.deleteById(enderecoId);
    }

    public Optional<Endereco> acharPorId(Long id) {
        return enderecoRepositorio.findById(id);
    }
}
