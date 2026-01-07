package com.ighor.projeto_crud.business.Service;

import com.ighor.projeto_crud.controller.Dto.UsuarioDto;
import com.ighor.projeto_crud.infrastructure.entity.Usuario;
import com.ighor.projeto_crud.infrastructure.repository.iUsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
public class UsuarioService {

    private final iUsuarioRepository usuarioRepository;

    public UsuarioService(iUsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public void salvarUsuario(UsuarioDto usuario){
        Usuario newUsuario = new Usuario();
        newUsuario.setId(usuario.getId());
        newUsuario.setNome(usuario.getNome());
        newUsuario.setEmail(usuario.getEmail());
        //Salva e fecha a conexao com o banco de dados
        usuarioRepository.saveAndFlush(newUsuario);
    }

    public List<UsuarioDto> buscarTodosUsuarios(){
        //Buscando por todos os Usuarios
        List<Usuario> usuarios = usuarioRepository.findAll();
        //mapeando as entidades para Dtos
        List<UsuarioDto> usuarioDtos = usuarios.stream()
                .map(usuario -> new UsuarioDto(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail()
                ))
                .toList(); // Java 16+
        return usuarioDtos;
    }

    public UsuarioDto buscarUsuarioPorId(Long id){
        //buscando usuario no banco,
        Usuario user = usuarioRepository.findById(id)
                //se nao encontrar jogamos expetion
                .orElseThrow(() -> new RuntimeException("Id de Usuario nao encontrado"));
        //construindo dto para retornar
        UsuarioDto userDto = new UsuarioDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setNome(user.getNome());
        return userDto;
    }

    public UsuarioDto buscarUsuarioPorEmail(String email){
        //buscando usuario no banco,
        Usuario user = usuarioRepository.findByEmail(email)
                //se nao encontrar jogamos expetion
                .orElseThrow(() -> new RuntimeException("Email nao encontrado"));
        //construindo dto para retornar
        UsuarioDto userDto = new UsuarioDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setNome(user.getNome());
        return userDto;
    }

    @Transactional
    public void deletarPorEmail(String email){
        try {
            usuarioRepository.deleteByEmail(email);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void deletarPorId(Long id){
        try {
            usuarioRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void atualizarUsuarioPorEmail(String email, UsuarioDto userDto){
        Usuario userEntity = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email nao encontrado"));
        Usuario updatedUser = Usuario.builder()
                //checando se o objeto de usuario que recebemos do cliente tem um campo email
                //Se tiver signifca que o usuario quer atualizar o campo entao usamos esse campo no novo objeto
                .email(userDto.getEmail() != null ? userDto.getEmail() : userEntity.getEmail())
                //Mesmo coisa do email
                .nome(userDto.getNome() != null ? userDto.getNome() : userEntity.getNome())
                //Id eh unico entao pegamos direto da entity
                .id(userEntity.getId())
                .build();
        usuarioRepository.saveAndFlush(updatedUser);
    }

    @Transactional
    public void atualizarUsuarioPorId(Long id, UsuarioDto userDto){
        Usuario userEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id de Usuario nao encontrado"));
        Usuario updatedUser = Usuario.builder()
                //checando se o objeto de usuario que recebemos do cliente tem um campo email
                //Se tiver signifca que o usuario quer atualizar o campo entao usamos esse campo no novo objeto
                .email(userDto.getEmail() != null ? userDto.getEmail() : userEntity.getEmail())
                //Mesmo coisa do email
                .nome(userDto.getNome() != null ? userDto.getNome() : userEntity.getNome())
                //Id eh unico entao pegamos direto da entity
                .id(userEntity.getId())
                .build();
        usuarioRepository.saveAndFlush(updatedUser);
    }
}

