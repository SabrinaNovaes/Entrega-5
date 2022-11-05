package com.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.model.Usuarios;
import com.cadastro.service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("{id}")
	public ResponseEntity<Usuarios> findById(@PathVariable Long id) {
		Usuarios usuario = usuarioService.getUsuariosById(id);
		return ResponseEntity.ok().body(usuario);
	}
		
	@GetMapping
	public ResponseEntity<List<Usuarios>> findAll() {
		List<Usuarios> usuarios = usuarioService.getAllUsuarios();
		return ResponseEntity.ok().body(usuarios);
	}

	@PostMapping
	public ResponseEntity<Usuarios> save(@RequestBody Usuarios usuarios) {
		Usuarios usuario = usuarioService.saveUsuarios(usuarios);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Usuarios> updateUsuarios(@PathVariable("id") long id, 
			@RequestBody Usuarios usuario) {
		return new ResponseEntity<Usuarios>(usuarioService.updateUsuarios(usuario, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUsuarios(@PathVariable("id") long id) {
		usuarioService.deleteUsuarios(id);
	
	return new ResponseEntity<String>("Usuário deletado com sucesso!",
			HttpStatus.OK);
	}
}
