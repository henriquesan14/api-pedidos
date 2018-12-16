package br.com.henrique.repository;

import br.com.henrique.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<ItemPedido, Long> {
}
