package com.edigital.springmvcsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.edigital.springmvcsecurity.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	// Listar todos usuarios
	@GetMapping("/")
	public String listar(ModelMap model) {
		model.addAttribute("usuarios", usuarioService.BuscarTodos());
		return "/usuario/listaUsuario";
	}

}
