package com.cadastrocliente.Initial.service;

import com.cadastrocliente.Initial.model.dto.EnderecoDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {

    public EnderecoDTO BuscarEndereco(final String cep){

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        EnderecoDTO enderecoCompleto = restTemplate.getForObject("https://api.postmon.com.br/v1/cep/" + cep, EnderecoDTO.class);

        return enderecoCompleto;
    }
}
