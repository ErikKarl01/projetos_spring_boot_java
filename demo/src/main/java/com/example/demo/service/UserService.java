package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repositorio.UserRepositorio;
import com.example.demo.dto.UserDTO;
import java.util.List;
import java.util.stream.Collectors;

// O serviço UserService é responsável por fornecer métodos para manipular usuários,
// como buscar todos os usuários do banco de dados e converter entidades User em UserDTO.

@Service
public class UserService {
 
    // O UserService utiliza o UserRepositorio para acessar os dados do banco de dados.
    @Autowired
    private UserRepositorio userRepositorio;


    // Método para buscar todos os usuários do banco de dados e convertê-los em UserDTO.
    // Isso permite que a aplicação trabalhe com uma representação simplificada dos dados,
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepositorio.findAll();
        // Converte a lista de User para uma lista de UserDTO usando streams.
        // Isso é útil para evitar expor diretamente a entidade User, mantendo a separação de preocupações.
        return users.stream() // Inicia um stream a partir da lista de usuários
                    .map(user -> new UserDTO(user.getId(), user.getNome(), user.getCpf()))// Mapeia cada User para um UserDTO, extraindo apenas os campos necessários 
                    .collect(Collectors.toList());// Coleta os resultados em uma lista de UserDTO e a retorna
    } 
}
