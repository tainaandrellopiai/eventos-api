package com.taina.eventos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taina.eventos.domain.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

	@Query("SELECT obj FROM Evento obj WHERE obj.local.id = :id_lugar ORDER BY nome")
	List<Evento> findAllByLugar(@Param(value="id_lugar") Integer id_lugar);

}
