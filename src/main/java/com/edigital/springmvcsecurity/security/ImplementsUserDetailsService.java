
package com.edigital.springmvcsecurity.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.edigital.springmvcsecurity.model.Usuario;
import com.edigital.springmvcsecurity.repository.UsuarioRepository;

@Repository

@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository ur;

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Usuario usuario = ur.findByEmail(email);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());

	}

}
