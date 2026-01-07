package com.ighor.projeto_crud.infrastructure.repository;

import com.ighor.projeto_crud.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface iUsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    void deleteByEmail (String email);

    void deleteById (Long id);
}
