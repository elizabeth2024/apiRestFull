package com.springbootweb.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.springbootweb.apiirest.models.services.IUsuarioService;
import com.springbootweb.apirestmodels.entity.Usuario;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/apiUsuario")

public class UsuarioRestController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/listarUsuario")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@PostMapping("/guardarUsuario")
	@ResponseStatus (HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario){
		return usuarioService.save(usuario);
	}
	
	@GetMapping("/buscarUsuario/{id}")	
	public Usuario show(@PathVariable Long id) {
		return usuarioService.findById(id);
	}
	
	@DeleteMapping("/eliminarUsuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
	
	@PutMapping("/editarUsuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioActual=usuarioService.findById(id);
		usuarioActual.setEstado(usuario.getEstado());
		usuarioActual.setClave(usuario.getClave());
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setEmail(usuario.getEmail());
		return usuarioService.save(usuarioActual);
	}
}
