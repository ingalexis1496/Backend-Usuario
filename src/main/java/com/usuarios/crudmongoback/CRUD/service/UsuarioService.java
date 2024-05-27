package com.usuarios.crudmongoback.CRUD.service;

import java.io.Console;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuarios.crudmongoback.CRUD.dto.UsuarioDto;
import com.usuarios.crudmongoback.CRUD.entity.Usuario;
import com.usuarios.crudmongoback.CRUD.repository.UsuarioRepository;
import com.usuarios.crudmongoback.global.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAll(){
		
		return usuarioRepository.findAll();
	}
	
	public Usuario getOne(int id) throws ResourceNotFoundException {
		
		return usuarioRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(""));
	}
	
	public Usuario save(UsuarioDto dto) {
		
		//int id = autoIncrementar();
	
		Usuario usuario = new Usuario(dto.getNumIdentificacion(),dto.getTipoIdentificacion(),
				dto.getFechaNacimiento(),dto.getEdad(),
				dto.getTelefono(),dto.getCorreo(),dto.getContrasena());
	
		return usuarioRepository.save(usuario);
	
		
	}
	
	public Usuario update(int id, UsuarioDto dto) throws ResourceNotFoundException {
		
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(""));
		
		usuario.setFechaNacimiento(dto.getFechaNacimiento());
		usuario.setEdad(dto.getEdad());
		usuario.setTelefono(dto.getTelefono());
		usuario.setFechaNacimiento(dto.getFechaNacimiento());
		usuario.setCorreo(dto.getCorreo());
		
		
		return usuarioRepository.save(usuario);
	}
	
	public Usuario delete(int id) throws ResourceNotFoundException{
		
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No Encontrado"));
		usuarioRepository.delete(usuario);
		
		return usuario;
	}
	
	//Metodos
	/*
	private int autoIncrementar() {
		
		List <Usuario> usuarios = usuarioRepository.findAll();
		
		return usuarios.isEmpty()? 1 :
			usuarios.stream().max(Comparator.comparing(Usuario::getNumIdentificacion)).get().getNumIdentificacion() + 1;	
	}
	*/
	
	
}
