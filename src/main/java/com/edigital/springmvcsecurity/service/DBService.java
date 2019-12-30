package com.edigital.springmvcsecurity.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.edigital.springmvcsecurity.model.Role;
import com.edigital.springmvcsecurity.model.Usuario;
import com.edigital.springmvcsecurity.repository.RoleRepository;
import com.edigital.springmvcsecurity.repository.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void instantiateTestDatabase() throws ParseException {

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