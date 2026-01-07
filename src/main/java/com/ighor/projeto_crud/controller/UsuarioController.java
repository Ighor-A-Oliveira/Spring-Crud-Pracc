package com.ighor.projeto_crud.controller;

import com.ighor.projeto_crud.business.Service.UsuarioService;
import com.ighor.projeto_crud.controller.Dto.UsuarioDto;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> salvarUsuario(@RequestBody UsuarioDto userDto){
        usuarioService.salvarUsuario(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar/all")
    public ResponseEntity<List<UsuarioDto>> buscarTodosUsuarios(){
        List<UsuarioDto> userDtos = usuarioService.buscarTodosUsuarios();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/buscar/por-id")
    public ResponseEntity<UsuarioDto> buscarUsuarioPorId(@RequestParam Long id){
        UsuarioDto userDto = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/buscar/por-email")
    public ResponseEntity<UsuarioDto> buscarUsuarioPorEmail(@RequestParam String email){
        UsuarioDto userDto = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/deletar/por-id")
    public ResponseEntity<Void> deletarUsuarioPorId(@RequestParam Long id){
        usuarioService.deletarPorId(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletar/por-email")
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizar/por-id")
    public ResponseEntity<UsuarioDto> atualizarUsuarioPorId(@RequestParam Long id, @RequestBody UsuarioDto userDto){
        usuarioService.atualizarUsuarioPorId(id, userDto);
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    @PutMapping("/atualizar/por-email")
    public ResponseEntity<UsuarioDto> atualizarUsuarioPorEmail(@RequestParam String email, @RequestBody UsuarioDto userDto){
        usuarioService.atualizarUsuarioPorEmail(email, userDto);
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

}
