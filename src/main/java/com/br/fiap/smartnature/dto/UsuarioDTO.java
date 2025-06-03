package com.br.fiap.smartnature.dto;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String tipo;
    private Long logradouroId;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nome, String email, String telefone, String tipo, Long logradouroId) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipo = tipo;
        this.logradouroId = logradouroId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getLogradouroId() {
        return logradouroId;
    }

    public void setLogradouroId(Long logradouroId) {
        this.logradouroId = logradouroId;
    }
}
