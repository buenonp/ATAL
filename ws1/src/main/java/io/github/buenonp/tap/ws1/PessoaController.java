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
	public ResponseEntity< List<Pessoa> > listAllPessoas() {
		
		List<Pessoa> listaPessoasExemplo = new ArrayList<Pessoa>();
		listaPessoasExemplo.add(new Pessoa(1,"Bueno", "9876543-SDS/PB", "123.456.789-00", "Rua etc e tal, N 56, Campina Grande, Paraíba, Brasil"));
		listaPessoasExemplo.add(new Pessoa(2,"Carioca", "9876543-SDS/PB", "123.456.789-00", "Rua qualquer, N 123, Campina Grande, Paraíba, Brasil"));
		listaPessoasExemplo.add(new Pessoa(3,"Rayana", "9876543-SDS/PB", "123.456.789-00", "Rua não me interessa, N 9090, Campina Grande, Paraíba, Brasil"));
		
		return new ResponseEntity< List<Pessoa> >
			(listaPessoasExemplo, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Pessoa> getPessoa(@PathVariable String id) {
		
		Pessoa pessoaExemplo = new Pessoa(1,"Bueno", "9876543-SDS/PB", "123.456.789-00", "Rua etc e tal, N 56, Campina Grande, Paraíba, Brasil");
		
		return pessoaExemplo == null ? 
				new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Pessoa>(pessoaExemplo, HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<String> createPessoa(@RequestBody Pessoa participant) {

		try {
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/", method = RequestMethod.PUT)
	public ResponseEntity<String> updatePessoa(@RequestBody Pessoa participant) {

		try {
			
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Pessoa> deletePessoaPorId(@PathVariable String id) {
	
		try {
			Pessoa pessoaExemplo = null;
			
			if(pessoaExemplo == null) {
				return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Pessoa>(pessoaExemplo, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
