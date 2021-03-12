package com.taina.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taina.eventos.domain.Evento;
import com.taina.eventos.domain.Lugar;
import com.taina.eventos.repository.EventoRepository;
import com.taina.eventos.service.exceptions.ObjectNotFoundException;

@Service
public class EventoService {

		@Autowired
		private EventoRepository repository;
		
		@Autowired
		private LugarService lugarService;
	
		
		public Evento findById(Integer id) {
			Optional<Evento> obj = repository.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id + ", Tipo " + Evento.class.getName()));
		}
		
		public List<Evento> findAll(Integer id_lugar) {
			lugarService.findById(id_lugar);
			return repository.findAllByLugar(id_lugar);
		}

		public Evento update(Integer id, Evento obj) {
			Evento newObj = findById(id);
			updateData(newObj, obj);
			return repository.save(newObj);
		}

		private void updateData(Evento newObj, Evento obj) {
			newObj.setNome(obj.getNome());
			newObj.setTipo(obj.getTipo());			
		}
		
		public Evento create(Integer id_lugar, Evento obj) {
			obj.setId(null);
			Lugar lug = lugarService.findById(id_lugar);
			obj.setLocal(lug);
			return repository.save(obj);
		}
		
		public void delete(Integer id) {
			Evento obj = findById(id);
			repository.delete(obj);
		}
		
}
