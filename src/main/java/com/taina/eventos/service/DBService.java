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
		Evento e1 = new Evento(null, "Carnaval", "Capivari Clube", l1);
		
		l1.getEventos().addAll(Arrays.asList(e1));
		this.lugarRepository.saveAll(Arrays.asList(l1));
		this.eventoRepository.saveAll(Arrays.asList(e1));
	}

}
