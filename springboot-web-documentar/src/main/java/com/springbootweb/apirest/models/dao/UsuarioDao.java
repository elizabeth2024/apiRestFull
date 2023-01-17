package com.springbootweb.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springbootweb.apirestmodels.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{

}
