package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.User;
import java.util.List;

// Aqui serão disponibilizados serviços de acesso ao banco de dados de usuários
// através de métodos que serão implementados automaticamente pelo Spring Data JPA.

@Repository
public interface UserRepositorio extends JpaRepository <User, Long> {

    User findByCpf(String cpf);

    List <User> queryByNameLike(String name); 
}
