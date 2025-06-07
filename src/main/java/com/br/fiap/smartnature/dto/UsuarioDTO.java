package com.br.fiap.smartnature.dto;

import jakarta.validation.constraints.*;

public class UsuarioDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @Size(max = 20, message = "Telefone deve ter no máximo 20 caracteres")
    private String telefone;

    @NotBlank(message = "Tipo é obrigatório")
    @Pattern(regexp = "^(cidadão|agente|admin)$", message = "Tipo deve ser 'cidadão', 'agente' ou 'admin'")
    private String tipo;

    @NotNull(message = "LogradouroId é obrigatório")
    private Long logradouroId;

    
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
