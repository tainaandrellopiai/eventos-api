package com.taina.eventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taina.eventos.domain.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

	@Query("SELECT obj from Evento obj WHERE obj.lugar.id =:id_lugar ORDER by nome")
	List<Evento> findAllByLugar(@Param(value="id_lugar") Integer id_lugar);

}
