package io.github.buenonp.tap.ws3;

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
public class UserController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity< List<User> > listAllUsers() {
		
		//dados fake
		List<User> listaUsuariosFake = new ArrayList<User>();
		listaUsuariosFake.add(new User(1,"Daniel","End1"));
		listaUsuariosFake.add(new User(2,"Ruan","End2"));
		listaUsuariosFake.add(new User(3,"Atylla","End3"));
		
		return new ResponseEntity< List<User> >
			(listaUsuariosFake, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String id) {
		
		User userFake = new User(1,"Daniel","End1");
		
		return userFake == null ? 
				new ResponseEntity<User>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<User>(userFake, HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User participant) {

		try {
			//salvar
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@RequestBody User participant) {

		try {
			//atualizar
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUserPorId(@PathVariable String id) {
	
		try {
			User userFake = null;
			//buscar o usu�rio por id
			
			if(userFake == null) {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
			
			//deleta o usu�rio no banco de dados
			return new ResponseEntity<User>(userFake, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
