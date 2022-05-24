package com.cadastrocliente.Initial.controller;

import com.cadastrocliente.Initial.model.domain.Cliente;
import com.cadastrocliente.Initial.model.dto.ClienteDTO;
import com.cadastrocliente.Initial.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ClienteDTO criar(@RequestBody final ClienteDTO dto) {
        final Cliente cliente = modelMapper.map(dto, Cliente.class);
        final Cliente clienteSalvo = clienteService.salvar(cliente);
        return modelMapper.map(clienteSalvo, ClienteDTO.class);
    }

    @GetMapping(path = "/{email}")
    public ClienteDTO obter(@PathVariable final String email) {
        final Cliente cliente = clienteService.EnderecosUsuario(email);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

}
