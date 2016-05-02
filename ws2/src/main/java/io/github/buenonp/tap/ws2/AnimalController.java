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

@RequestMapping(value="/animal")
@RestController
public class AnimalController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity< List<Animal> > listAllAnimais() {
		
		List<Animal> listaAnimaisExemplo = new ArrayList<Animal>();
		listaAnimaisExemplo.add(new Animal(1,"Bichano","Gato"));
		listaAnimaisExemplo.add(new Animal(2,"Totó","Cachorro"));
		listaAnimaisExemplo.add(new Animal(3,"AuAu","Cachorro"));
		
		return new ResponseEntity< List<Animal> >
			(listaAnimaisExemplo, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Animal> getAnimal(@PathVariable String id) {
		
		Animal animalExemplo = new Animal(1,"Bichano","Gato");
		
		return animalExemplo == null ? 
				new ResponseEntity<Animal>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Animal>(animalExemplo, HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<String> createAnimal(@RequestBody Animal participant) {

		try {
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAnimal(@RequestBody Animal participant) {

		try {
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Animal> deleteAnimalPorId(@PathVariable String id) {
	
		try {
			Animal animalExemplo = null;
			
			if(animalExemplo == null) {
				return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Animal>(animalExemplo, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Animal>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
