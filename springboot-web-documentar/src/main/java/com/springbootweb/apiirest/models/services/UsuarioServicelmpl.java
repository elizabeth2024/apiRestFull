package com.springbootweb.apiirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootweb.apirest.models.dao.UsuarioDao;
import com.springbootweb.apirestmodels.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicelmpl implements IUsuarioService{

	@Autowired
	private UsuarioDao UsuarioDao;
	
	
	@Override
	@Transactional (readOnly =true)

	public List<Usuario> findAll() {
			return (List<Usuario>)UsuarioDao.findAll();
	}

	@Override
	public Usuario save(Usuario usuario) {
		return UsuarioDao.save(usuario);
	}

	@Override
	public Usuario findById(Long id) {
		return UsuarioDao.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		UsuarioDao.deleteById(id);
		
	}

	
}
