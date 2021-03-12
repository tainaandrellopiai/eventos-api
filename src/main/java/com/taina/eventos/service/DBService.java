package com.taina.eventos.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taina.eventos.domain.Evento;
import com.taina.eventos.domain.Lugar;
import com.taina.eventos.repository.EventoRepository;
import com.taina.eventos.repository.LugarRepository;

@Service
public class DBService {
	
	@Autowired
	private LugarRepository lugarRepository;
	@Autowired
	private EventoRepository eventoRepository;
	
	public void instanciaBaseDeDados() {
		Lugar l1 = new Lugar(null, "Capivari Clube", 1000);
		Lugar l2 = new Lugar(null, "Cultura", 2000);
		Lugar l3 = new Lugar(null, "Praça", 5000);
		
		Evento e1 = new Evento(null, "Carnaval", "Privado", l1);
		Evento e2 = new Evento(null, "Festaaa", "Privado", l1);
		Evento e3 = new Evento(null, "Carnaval", "Público", l2);
		Evento e4 = new Evento(null, "Festa Fim de Ano", "Público", l2);
		
		l1.getEventos().addAll(Arrays.asList(e1,e2));
		l1.getEventos().addAll(Arrays.asList(e3,e4));
		
		
		this.lugarRepository.saveAll(Arrays.asList(l1,l2,l3));
		this.eventoRepository.saveAll(Arrays.asList(e1,e2,e3,e4));
	}

}
