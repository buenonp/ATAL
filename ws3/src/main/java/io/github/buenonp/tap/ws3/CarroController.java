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

@RequestMapping(value="/carro")
@RestController
public class CarroController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity< List<Carro> > listAllCarros() {
		
		List<Carro> listaCarrosExemplo = new ArrayList<Carro>();
		listaCarrosExemplo.add(new Carro(1,"PMD-3423","Gol"));
		listaCarrosExemplo.add(new Carro(2,"ETS-5739","Corsa"));
		listaCarrosExemplo.add(new Carro(3,"SJN-9065","Camaro"));
		
		return new ResponseEntity< List<Carro> >
			(listaCarrosExemplo, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Carro> getCarro(@PathVariable String id) {
		
		Carro carroExemplo = new Carro(1,"PMD-3423","Gol");
		
		return carroExemplo == null ? 
				new ResponseEntity<Carro>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Carro>(carroExemplo, HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<String> createCarro(@RequestBody Carro participant) {

		try {
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/", method = RequestMethod.PUT)
	public ResponseEntity<String> updateCarro(@RequestBody Carro participant) {

		try {
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Carro> deleteCarroPorId(@PathVariable String id) {
	
		try {
			Carro carroExemplo = null;
			
			if(carroExemplo == null) {
				return new ResponseEntity<Carro>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Carro>(carroExemplo, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Carro>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
