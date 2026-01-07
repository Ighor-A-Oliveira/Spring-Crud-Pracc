package com.ighor.projeto_crud.controller.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    public Long id;
    public String email;
    public String nome;
}
