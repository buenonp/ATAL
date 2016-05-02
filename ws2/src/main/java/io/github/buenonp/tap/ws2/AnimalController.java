package io.github.buenonp.tap.ws2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/user")
@RestController
public class AnimalController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity< List<Animal> > listAllUsers() {
		
		//dados fake
		List<Animal> listaUsuariosFake = new ArrayList<Animal>();
		listaUsuariosFake.add(new Animal(1,"Daniel","End1"));
		listaUsuariosFake.add(new Animal(2,"Ruan","End2"));
		listaUsuariosFake.add(new Animal(3,"Atylla","End3"));
		
		return new ResponseEntity< List<Animal> >
			(listaUsuariosFake, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Animal> getUser(@PathVariable String id) {
		
		Animal userFake = new Animal(1,"Daniel","End1");
		
		return userFake == null ? 
				new ResponseEntity<Animal>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Animal>(userFake, HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody Animal participant) {

		try {
			//salvar
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@RequestBody Animal participant) {

		try {
			//atualizar
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Animal> deleteUserPorId(@PathVariable String id) {
	
		try {
			Animal userFake = null;
			//buscar o usu�rio por id
			
			if(userFake == null) {
				return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
			}
			
			//deleta o usu�rio no banco de dados
			return new ResponseEntity<Animal>(userFake, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Animal>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
