
package com.br.fiap.smartnature.controller;

import com.br.fiap.smartnature.dto.NotificacaoDTO;
import com.br.fiap.smartnature.service.NotificacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificacaos")
public class NotificacaoController {

    @Autowired
    private NotificacaoService service;

    @Operation(summary = "Cria uma nova notificacao")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Notificacao criada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotificacaoDTO.class))),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content)
    })
    @PostMapping
    public NotificacaoDTO criar(@RequestBody NotificacaoDTO dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Lista todas as notificacoes")
    @GetMapping
    public List<NotificacaoDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Retorna uma notificacao por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notificacao encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotificacaoDTO.class))),
        @ApiResponse(responseCode = "404", description = "Notificacao não encontrada", content = @Content)
    })
    @GetMapping("{id}")
    public NotificacaoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualiza uma notificacao")
    @PutMapping("{id}")
    public NotificacaoDTO atualizar(@PathVariable Long id, @RequestBody NotificacaoDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Deleta uma notificacao")
    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
