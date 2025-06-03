
package com.br.fiap.smartnature.controller;

import com.br.fiap.smartnature.dto.LogAuditoriaDTO;
import com.br.fiap.smartnature.service.LogAuditoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logauditorias")
public class LogAuditoriaController {

    @Autowired
    private LogAuditoriaService service;

    @Operation(summary = "Cria um novo LogAuditoria")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "LogAuditoria criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LogAuditoriaDTO.class))),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content)
    })
    @PostMapping
    public LogAuditoriaDTO criar(@RequestBody LogAuditoriaDTO dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Lista todos os LogAuditorias")
    @GetMapping
    public List<LogAuditoriaDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Retorna um LogAuditoria por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "LogAuditoria encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LogAuditoriaDTO.class))),
        @ApiResponse(responseCode = "404", description = "LogAuditoria não encontrado", content = @Content)
    })
    @GetMapping("{id}")
    public LogAuditoriaDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualiza um LogAuditoria")
    @PutMapping("{id}")
    public LogAuditoriaDTO atualizar(@PathVariable Long id, @RequestBody LogAuditoriaDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Deleta um LogAuditoria")
    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
