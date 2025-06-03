
package com.br.fiap.smartnature.controller;

import com.br.fiap.smartnature.dto.SensorDTO;
import com.br.fiap.smartnature.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensores")
public class SensorController {

    @Autowired
    private SensorService service;

    @Operation(summary = "Cria um novo sensor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Sensor criado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SensorDTO.class))),
        @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content)
    })
    @PostMapping
    public SensorDTO criar(@RequestBody SensorDTO dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Lista todos os sensores")
    @GetMapping
    public List<SensorDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Retorna um sensor por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sensor encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SensorDTO.class))),
        @ApiResponse(responseCode = "404", description = "Sensor não encontrado", content = @Content)
    })
    @GetMapping("{id}")
    public SensorDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualiza um sensor")
    @PutMapping("{id}")
    public SensorDTO atualizar(@PathVariable Long id, @RequestBody SensorDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Deleta um sensor")
    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
