package com.taina.eventos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.taina.eventos.domain.Lugar;
import com.taina.eventos.dtos.LugarDTO;
import com.taina.eventos.repository.LugarRepository;
import com.taina.eventos.service.exceptions.ObjectNotFoundException;

@Service
public class LugarService {

	@Autowired
	private LugarRepository repository;
	public Lugar findById(Integer id) {
		Optional<Lugar> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Lugar.class.getName()));
	}
		
	public List<Lugar> findAll() {
		return repository.findAll();
	}
	
	public Lugar create(Lugar obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Lugar update(Integer id, LugarDTO objDTO) {
		Lugar obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setCapacidade(objDTO.getCapacidade());
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.taina.eventos.service.exceptions.DataIntegrityViolationException ("Lugar não pode ser deletado! Possui eventos associados");
		}
	}
}
