-
package com.br.fiap.smartnature.controller;

import com.br.fiap.smartnature.dto.AlertaDTO;
import com.br.fiap.smartnature.service.AlertaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    @Autowired
    private AlertaService service;

    @Operation(summary = "Cria um novo alerta")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Alerta criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlertaDTO.class))),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content)
    })
    @PostMapping
    public AlertaDTO criar(@RequestBody AlertaDTO dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Lista todos os alertas")
    @GetMapping
    public List<AlertaDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Retorna um alerta por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Alerta encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlertaDTO.class))),
        @ApiResponse(responseCode = "404", description = "Alerta não encontrado", content = @Content)
    })
    @GetMapping("{id}")
    public AlertaDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualiza um alerta")
    @PutMapping("{id}")
    public AlertaDTO atualizar(@PathVariable Long id, @RequestBody AlertaDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Deleta um alerta")
    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
