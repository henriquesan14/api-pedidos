package br.com.henrique.repository;

import br.com.henrique.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDao extends JpaRepository<Produto, Long> {

    Page<Produto> findAllByNomeContainingIgnoreCaseOrderByNomeAsc(Pageable pageable, String nome);
}
