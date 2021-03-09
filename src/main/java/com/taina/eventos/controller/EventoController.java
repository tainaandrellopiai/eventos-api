package com.taina.eventos.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import com.taina.eventos.domain.Evento;
import com.taina.eventos.service.EventoService;
import com.taina.eventos.dtos.EventoDTO;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/busca_evento")
public class EventoController {
	
	@Autowired
	private EventoService service;
		
	@GetMapping(value="/{id}")
	public ResponseEntity<Evento> findById(@PathVariable Integer id) {
		Evento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<EventoDTO>> findAll(@RequestParam(value="local", defaultValue="0") Integer id_lugar) {
		List<Evento> list = service.findAll(id_lugar);
		List<EventoDTO> listDTO = list.stream().map(obj -> new EventoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Evento> update(@PathVariable Integer id,@Valid @RequestBody Evento obj) {
		Evento newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PatchMapping(value="/{id}")
	public ResponseEntity<Evento> updatePatch(@PathVariable Integer id,@Valid @RequestBody Evento obj) {
		Evento newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Evento> create(@RequestParam(value="local", defaultValue="0") Integer id_lugar, @Valid @RequestBody Evento obj) {
		Evento newObj = service.create(id_lugar, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/eventos/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}


