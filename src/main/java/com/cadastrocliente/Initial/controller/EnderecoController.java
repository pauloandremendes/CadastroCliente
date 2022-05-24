package com.cadastrocliente.Initial.controller;

import com.cadastrocliente.Initial.model.dto.EnderecoDTO;
import com.cadastrocliente.Initial.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoDTO> consultaCep(@PathVariable String cep){

        EnderecoDTO endereco = enderecoService.BuscarEndereco(cep);
        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
    }

//    @GetMapping("/ceo")
//    public EnderecoDTO consultaCep(@PathVariable final String cep){
//        final EnderecoDTO endereco = enderecoService.BuscarEndereco(cep);
//        return modelMapper.map(endereco, EnderecoDTO.class);
//    }

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/{cep}")
//    public Endereco getCep(@PathVariable String cep) {
//        Endereco newCep = restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json/", Endereco.class);
//        return newCep;
//    }
}
