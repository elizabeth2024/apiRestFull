package com.springbootweb.apiirest.models.services;

import java.util.List;

import com.springbootweb.apirestmodels.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public Usuario findById(Long id);
	
	public void delete(Long id);
}
