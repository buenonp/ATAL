package io.github.buenonp.tap.ws1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/pessoa")
@RestController
public class PessoaController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity< List<Pessoa> > listAllUsers() {
		
		List<Pessoa> listaUsuariosFake = new ArrayList<Pessoa>();
		listaUsuariosFake.add(new Pessoa(1,"Bueno","Rua etc e tal, N 56, Campina Grande, Paraíba, Brasil"));
		listaUsuariosFake.add(new Pessoa(2,"Carioca","Rua qualquer, N 123, Campina Grande, Paraíba, Brasil"));
		listaUsuariosFake.add(new Pessoa(3,"Rayana","Rua não me interessa, N 9090, Campina Grande, Paraíba, Brasil"));
		
		return new ResponseEntity< List<Pessoa> >
			(listaUsuariosFake, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Pessoa> getUser(@PathVariable String id) {
		
		Pessoa userFake = new Pessoa(1,"Bueno","Rua etc e tal, N 56, Campina Grande, Paraíba, Brasil");
		
		return userFake == null ? 
				new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Pessoa>(userFake, HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody Pessoa participant) {

		try {
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@RequestBody Pessoa participant) {

		try {
			
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Pessoa> deleteUserPorId(@PathVariable String id) {
	
		try {
			Pessoa userFake = null;
			
			if(userFake == null) {
				return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Pessoa>(userFake, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
