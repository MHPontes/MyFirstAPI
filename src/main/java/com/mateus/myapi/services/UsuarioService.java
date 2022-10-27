package com.mateus.myapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.myapi.domain.Usuario;
import com.mateus.myapi.repositories.UsuarioRepository;
import com.mateus.myapi.services.exceptions.ObjectNotFoundException;

@Service // Informando que esta e uma classe de serviço
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ",Tipo: " + Usuario.class.getName()));
	}

	public List<Usuario> findAll() {
		 return repository.findAll();
	}

	public Usuario update(Integer id, Usuario obj) {           //Metodo responsavel por realizar o update 
		Usuario newObj = findById(id);
		newObj.setNome(obj.getNome());
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());
		return repository.save(newObj);
	}

	public Usuario create(Usuario obj) {
		obj.setId(null);
		return repository.save(obj);
		
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

}
