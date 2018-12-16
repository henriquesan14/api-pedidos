package br.com.henrique.repository;

import br.com.henrique.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDao extends JpaRepository<Pedido, Long> {
}
