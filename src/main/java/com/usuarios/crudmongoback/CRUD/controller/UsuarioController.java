package com.usuarios.crudmongoback.CRUD.controller;


import org.springframework.beans.factory.annotation.Autowired;
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

import com.usuarios.crudmongoback.CRUD.dto.UsuarioDto;
import com.usuarios.crudmongoback.CRUD.entity.Usuario;
import com.usuarios.crudmongoback.CRUD.service.UsuarioService;
import com.usuarios.crudmongoback.global.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
	
	
	@Autowired
	UsuarioService usuarioService;
	
	 @GetMapping
	    public ResponseEntity<List<Usuario>> getAll() {
	        return ResponseEntity.ok(usuarioService.getAll());
	    }

	    @GetMapping("/{cedula}")
	    public ResponseEntity<Usuario> getOne(@PathVariable("cedula") int cedula) throws ResourceNotFoundException {
	        return ResponseEntity.ok(usuarioService.getOne(cedula));
	    }

	    @PostMapping
	    public ResponseEntity<Usuario> save(@Valid @RequestBody UsuarioDto dto) {
	        return ResponseEntity.ok(usuarioService.save(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Usuario> update(@Valid @PathVariable("id") int id, @RequestBody UsuarioDto dto)
	    		throws ResourceNotFoundException{
	        return ResponseEntity.ok(usuarioService.update(id, dto));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Usuario> delete(@PathVariable("id") int id)
	    		throws ResourceNotFoundException{
	        return ResponseEntity.ok(usuarioService.delete(id));
	    }
}
