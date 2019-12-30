package com.edigital.springmvcsecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edigital.springmvcsecurity.model.Usuario;
import com.edigital.springmvcsecurity.repository.UsuarioRepository;
import com.edigital.springmvcsecurity.service.execption.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	

	// Salvar usuario
	public Usuario salvart(Usuario obj) {
		obj.setId(null);
		return usuarioRepository.save(obj);

	}

	// Buscar usuário por id
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	// Buscar todos usuarios
	public List<Usuario> BuscarTodos() {
		return usuarioRepository.findAll();
	}

	// Buscar usuario por email
	public Usuario buscarPorEmail(String email) {
	Usuario	usuario = usuarioRepository.findByEmail(email);
		return usuario;
	}
	
	// Buscar usuario por nome
	public Usuario buscarPorNome(String nome) {
		Usuario usuario = usuarioRepository.findByNome(nome);
		return usuario;
	}

	// Atualizacao do usuario
	public Usuario update(Usuario obj) {
		Usuario newObj = buscarPorId(obj.getId());
		return usuarioRepository.save(newObj);
	}

}
