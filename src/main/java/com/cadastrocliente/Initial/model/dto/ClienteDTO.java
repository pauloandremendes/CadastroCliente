package com.cadastrocliente.Initial.model.dto;

import com.cadastrocliente.Initial.model.domain.Endereco;

import java.io.Serializable;
import java.util.List;

public class ClienteDTO implements Serializable {

    private long id;
    private String email;
    private List<Endereco> enderecos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
