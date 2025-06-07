package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;

import jakarta.annotation.PostConstruct;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class UserController {

	private static List<UserDTO> usuarios = new ArrayList<>(); 

	@PostConstruct
	public void initialiZR(){
		UserDTO user1 = new UserDTO();
        user1.setNome("Eduardo");
        user1.setCpf("123");
        user1.setEndereco("Rua A");
        user1.setEmail("eduardo@email.com");
        user1.setTelefone("1234-5678");
        user1.setDataCadastro(new Date());

        UserDTO user2 = new UserDTO();
        user2.setNome("Luiz");
        user2.setCpf("456");
        user2.setEndereco("Rua B");
        user2.setEmail("luiz@email.com");
        user2.setTelefone("2345-6789");
        user2.setDataCadastro(new Date());

        UserDTO user3 = new UserDTO();
        user3.setNome("Bruna");
        user3.setCpf("789");
        user3.setEndereco("Rua C");
        user3.setEmail("bruna@email.com");
        user3.setTelefone("3456-7890");
        user3.setDataCadastro(new Date());

        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
	}

	@GetMapping("/users")
	public List<UserDTO> getUsuarios(){
		return usuarios;
	}

	@GetMapping("/users/{cpf}")
	public UserDTO getUserDTO(@PathVariable String cpf){
		for (UserDTO getUserDTO : usuarios) {
			if (getUserDTO.getCpf().equals(cpf)) {
				return getUserDTO;
			}
		}
		return null;
	}
	
	@PostMapping("newUser")
	public UserDTO addUsuariUserDTO(@RequestBody UserDTO userDTO){
		userDTO.setDataCadastro(new Date());
		usuarios.add(userDTO);
		return userDTO;
	}

	@DeleteMapping("/delete/{cpf}")
	public boolean removeUser(@PathVariable String cpf){
		for (UserDTO userDTO : usuarios) {
			if (userDTO.getCpf().equals(cpf)) {
				usuarios.remove(userDTO);
				return true;
			}
		}
		return false;
	}
	
}