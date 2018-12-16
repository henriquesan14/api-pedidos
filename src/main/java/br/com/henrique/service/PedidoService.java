package br.com.henrique.service;

import br.com.henrique.domain.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    Pedido salvar(Pedido pedido);
    List<Pedido> recuperar();
    Optional<Pedido> recuperarPorId(Long id);
    Pedido atualizar(Pedido pedido);
    void apagar(Long id);
}
