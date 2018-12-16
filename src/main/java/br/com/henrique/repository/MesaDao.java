package br.com.henrique.repository;

import br.com.henrique.domain.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaDao extends JpaRepository<Mesa, Long> {
}
