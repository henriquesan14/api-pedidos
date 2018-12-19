package br.com.henrique.repository;

import br.com.henrique.domain.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MesaDao extends JpaRepository<Mesa, Long> {


}
