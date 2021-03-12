package com.taina.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taina.eventos.domain.Lugar;

@Repository
public interface LugarRepository extends JpaRepository<Lugar, Integer> {

}
