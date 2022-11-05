 package com.cadastro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cadastro.exception.ResourceNotFoundException;
import com.cadastro.model.Usuarios;
import com.cadastro.repositories.UsuarioRepository;
import com.cadastro.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public Usuarios execute(Usuarios usuarios) {
		Usuarios usuarioExiste = usuarioRepository.findByEmail(usuarios.getEmail());
	
		if(usuarioExiste != null) {
			throw new Error("Usuário não encontrado");
		}
		
		usuarios.setSenha(passwordEncoder().encode(usuarios.getSenha()));
		Usuarios createdUsuario = usuarioRepository.save(usuarios);
		
		return createdUsuario;
	}
	
	@Override
	public Usuarios saveUsuarios(Usuarios usuarios) {
		return usuarioRepository.save(usuarios);
	}

	@Override
	public List<Usuarios> getAllUsuarios() {
		return usuarioRepository.findAll();
	}
	
	@Override
	public Usuarios getUsuariosById(long id) {
		return usuarioRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Usuário", "id", id));
	}
	
	@Override
	public Usuarios updateUsuarios(Usuarios usuarios, long id) {
		
		Usuarios usuarioExistente = usuarioRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Usuario", "id", id));
		
		usuarioExistente.setNome(usuarios.getNome());
		usuarioExistente.setSobrenome(usuarios.getSobrenome());
		usuarioExistente.setCpf(usuarios.getCpf());
		usuarioExistente.setData_nascimento(usuarios.getData_nascimento());
		usuarioExistente.setTelefone(usuarios.getTelefone());
		usuarioExistente.setEmail(usuarios.getEmail());
		usuarioExistente.setSenha(usuarios.getSenha());
		
		usuarioRepository.save(usuarioExistente);
		return usuarioExistente;
	}
	
	@Override
	public void deleteUsuarios(long id) {
		usuarioRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Usuarios", "id", id));
	}
	
}

