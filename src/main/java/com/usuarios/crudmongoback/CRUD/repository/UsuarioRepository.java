package com.usuarios.crudmongoback.CRUD.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.usuarios.crudmongoback.CRUD.entity.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {

}
