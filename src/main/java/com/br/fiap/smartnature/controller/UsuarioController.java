
package com.br.fiap.smartnature.controller;

import com.br.fiap.smartnature.dto.UsuarioDTO;
import com.br.fiap.smartnature.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Operation(summary = "Cria um novo usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Usuario criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class))),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content)
    })
    @PostMapping
    public UsuarioDTO criar(@RequestBody UsuarioDTO dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Lista todos os usuarios")
    @GetMapping
    public List<UsuarioDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Retorna um usuario por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class))),
        @ApiResponse(responseCode = "404", description = "Usuario não encontrado", content = @Content)
    })
    @GetMapping("{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualiza um usuario")
    @PutMapping("{id}")
    public UsuarioDTO atualizar(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Deleta um usuario")
    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
