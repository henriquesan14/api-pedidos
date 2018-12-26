package br.com.henrique.repository;

import br.com.henrique.domain.Mesa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaDao extends JpaRepository<Mesa, Long> {


    Page<Mesa> findAllByNomeContainingIgnoreCaseOrderByNomeAsc(Pageable pageable, String nome);
}
