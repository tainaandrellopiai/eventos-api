package com.taina.eventos.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import com.taina.eventos.domain.Lugar;
import com.taina.eventos.service.LugarService;
import com.taina.eventos.dtos.LugarDTO;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/busca_lugar")
public class LugarController {
	
	@Autowired
	private LugarService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Lugar> findById (@PathVariable Integer id) {
		Lugar obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<LugarDTO>> findAll() {
		List<Lugar> list = service.findAll();
		List<LugarDTO> listDTO = list.stream().map(obj -> new LugarDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<Lugar> create(@Valid @RequestBody Lugar obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<LugarDTO> update(@Valid @PathVariable Integer id, @RequestBody LugarDTO objDTO) {
		Lugar newObj = service.create(id, objDTO);
		return ResponseEntity.ok().body(new LugarDTO(newObj));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
