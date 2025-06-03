
package com.br.fiap.smartnature.controller;

import com.br.fiap.smartnature.dto.LogradouroDTO;
import com.br.fiap.smartnature.service.LogradouroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logradouros")
public class LogradouroController {

    @Autowired
    private LogradouroService service;

    @Operation(summary = "Cria um novo logradouro")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Logradouro criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LogradouroDTO.class))),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content)
    })
    @PostMapping
    public LogradouroDTO criar(@RequestBody LogradouroDTO dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Lista todos os logradouros")
    @GetMapping
    public List<LogradouroDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Retorna um logradouro por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Logradouro encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LogradouroDTO.class))),
        @ApiResponse(responseCode = "404", description = "Logradouro não encontrado", content = @Content)
    })
    @GetMapping("{id}")
    public LogradouroDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualiza um logradouro")
    @PutMapping("{id}")
    public LogradouroDTO atualizar(@PathVariable Long id, @RequestBody LogradouroDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Deleta um logradouro")
    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
