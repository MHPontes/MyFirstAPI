package com.mateus.myapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mateus.myapi.domain.Usuario;
import com.mateus.myapi.services.UsuarioService;



// Aqui também pode se chamar de Controllers, mas nesse caso, estamos utilizando como Resource

@RestController
@RequestMapping(value = "/usuarios")   //Mapeando o Request
public class UsuarioResource {    
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/{id}")          // Metodo find por ID, para buscar o usuario por ID
	public ResponseEntity<Usuario> findById(@PathVariable Integer id){
		Usuario obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping            //Metodo find por ID, porém buscando todos os usuarios.
	public ResponseEntity<List<Usuario>>findAll(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping(value = "/{id}")         //Metodo update por ID.
	public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario obj){
		Usuario newObj = service.update (id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> create( @RequestBody Usuario obj){
		Usuario newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	

}
