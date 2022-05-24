package com.cadastrocliente.Initial.service;

import com.cadastrocliente.Initial.model.domain.Cliente;
import com.cadastrocliente.Initial.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(final Cliente cliente) {
        Cliente clientePresete = clienteRepository.findByEmail(cliente.getEmail());

        if (clientePresete != null) {
            clientePresete.getEnderecos().addAll(cliente.getEnderecos());
            clientePresete.getEnderecos().stream().forEach(enderecos -> enderecos.setCliente(clientePresete));
            return clienteRepository.save(clientePresete);
        } else {
            cliente.getEnderecos().stream().forEach(enderecos -> enderecos.setCliente(cliente));
            return clienteRepository.save(cliente);
        }
    }

    public Cliente EnderecosUsuario(final String email) {
        Cliente enderecoCliente = clienteRepository.findByEmail(email);
        if (enderecoCliente != null) {
            return enderecoCliente;
        } else {
            return null;
        }
    }
}
