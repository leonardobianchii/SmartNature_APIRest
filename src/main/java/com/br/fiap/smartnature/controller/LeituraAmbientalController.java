
package com.br.fiap.smartnature.controller;

import com.br.fiap.smartnature.dto.LeituraAmbientalDTO;
import com.br.fiap.smartnature.service.LeituraAmbientalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leituras")
public class LeituraAmbientalController {

    @Autowired
    private LeituraAmbientalService service;

    @Operation(summary = "Cria uma nova Leitura Ambiental")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "LeituraAmbiental criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LeituraAmbientalDTO.class))),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content)
    })
    @PostMapping
    public LeituraAmbientalDTO criar(@RequestBody LeituraAmbientalDTO dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Lista todas as Leituras Ambientais")
    @GetMapping
    public List<LeituraAmbientalDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Retorna uma Leitura Ambiental por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "LeituraAmbiental encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LeituraAmbientalDTO.class))),
        @ApiResponse(responseCode = "404", description = "LeituraAmbiental não encontrado", content = @Content)
    })
    @GetMapping("{id}")
    public LeituraAmbientalDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualiza uma Leitura Ambiental")
    @PutMapping("{id}")
    public LeituraAmbientalDTO atualizar(@PathVariable Long id, @RequestBody LeituraAmbientalDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Deleta uma Leitura Ambiental")
    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
