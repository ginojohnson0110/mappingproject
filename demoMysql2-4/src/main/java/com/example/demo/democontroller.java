package com.example.demo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class democontroller {
	@Autowired
	myrepo repo;
	@PostMapping("/postdata")
	public ResponseEntity<Person> postdata(@RequestBody Person k)
	{
		return new ResponseEntity<>(repo.save(k), HttpStatus.FOUND);

	}
	@GetMapping("/getdata")
	public ResponseEntity<List<Person>> postdata()
	{
		return new ResponseEntity<>(repo.findAll(),HttpStatus.FOUND);

	}
	@GetMapping("/apidata/{id}")
	public ResponseEntity<Person> getsingledata(@PathVariable long id )
	{
		Optional<Person> obj = repo.findById(id);
		if(obj.isPresent()) {
			return new ResponseEntity<>(obj.get(), HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/apidata/{id}")
	public ResponseEntity<Person> updatedata(@PathVariable long id, @RequestBody Person a)
	{
		Optional<Person> obj = repo.findById(id);
		if(obj.isPresent()) {
			obj.get().setAuthorid(a.getAuthorid());
			obj.get().setAddress(a.getAddress());
			return new ResponseEntity<>(repo.save(obj.get()), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/apidata/{id}")
	public ResponseEntity<Person> deletesingledata(@PathVariable long id )
	{
		Optional<Person> obj = repo.findById(id);
		if(obj.isPresent()) {
			repo.deleteById(id);
			return new ResponseEntity<>( HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
