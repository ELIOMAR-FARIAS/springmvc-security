package com.edigital.springmvcsecurity;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.edigital.springmvcsecurity.model.Role;
import com.edigital.springmvcsecurity.model.Usuario;
import com.edigital.springmvcsecurity.repository.RoleRepository;
import com.edigital.springmvcsecurity.repository.UsuarioRepository;

@SpringBootApplication
public class SpringmvcSecurityApplication  implements CommandLineRunner  {	

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Role role = new Role(Long.valueOf(1), "ROLE_ADMIN");
		Role role1 = new Role(Long.valueOf(2), "ROLE_USER");

		roleRepository.saveAll(Arrays.asList(role, role1));

		Usuario usuario = new Usuario(null, "Eliomar Farias", "eliomar.lima.farias@gmail.com", pe.encode("123"));
		usuario.getRoles().add(role);

		Usuario usuario1 = new Usuario(null, "Ariel Farias", "ariel.maciel.farias@gmail.com", pe.encode("123"));
		usuario1.getRoles().add(role1);

		usuarioRepository.saveAll(Arrays.asList(usuario, usuario1));

	}

}
