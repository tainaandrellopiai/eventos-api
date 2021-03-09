package com.taina.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taina.eventos.domain.Lugar;

public interface LugarRepository extends JpaRepository<Lugar, Integer> {

}
