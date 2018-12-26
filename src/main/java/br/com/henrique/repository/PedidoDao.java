package br.com.henrique.repository;

import br.com.henrique.domain.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoDao extends JpaRepository<Pedido, Long> {

    Page<Pedido> findAllByMesaNomeContainingIgnoreCaseOrderByDataPedidoAsc(Pageable pageable, String mome);
}
