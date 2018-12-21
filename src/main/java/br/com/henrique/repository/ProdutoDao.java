package br.com.henrique.repository;

import br.com.henrique.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDao extends JpaRepository<Produto, Long> {


}
