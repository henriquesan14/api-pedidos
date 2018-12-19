package br.com.henrique.repository;

import br.com.henrique.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoDao extends JpaRepository<Produto, Long> {


}
